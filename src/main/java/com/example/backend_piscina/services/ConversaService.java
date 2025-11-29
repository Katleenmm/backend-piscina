package com.example.backend_piscina.services;

import com.example.backend_piscina.dtos.*;
import com.example.backend_piscina.entities.Cliente;
import com.example.backend_piscina.entities.Conversa;
import com.example.backend_piscina.entities.Mensagem;
import com.example.backend_piscina.mappers.ConversaMapper;
import com.example.backend_piscina.repositories.ClienteRepository;
import com.example.backend_piscina.repositories.ConversaRepository;
import com.example.backend_piscina.repositories.MensagemRepository;
import org.springframework.stereotype.Service;
import java.util.Base64;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ConversaService {

    private final ConversaRepository conversaRepository;
    private final ClienteRepository clienteRepository;
    private final ConversaMapper conversaMapper;
    private final MensagemRepository mensagemRepository; // ✅ ADICIONAR

    public ConversaService(
            ConversaRepository conversaRepository,
            ClienteRepository clienteRepository,
            ConversaMapper conversaMapper,
            MensagemRepository mensagemRepository // ✅ ADICIONAR
    ) {
        this.conversaRepository = conversaRepository;
        this.clienteRepository = clienteRepository;
        this.conversaMapper = conversaMapper;
        this.mensagemRepository = mensagemRepository; // ✅ ADICIONAR
    }

    public ConversaDTO criarConversa(ConversaCreateDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.idCliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Conversa conversa = new Conversa();
        conversa.setCliente(cliente);
        conversa.setDataConversa(LocalDateTime.now());

        Conversa saved = conversaRepository.save(conversa);

        ClienteOutputDTO clienteDTO = new ClienteOutputDTO(
                cliente.getIdCliente(),
                cliente.getLogin(),
                cliente.getName(),
                cliente.getTelefone()
        );

        return new ConversaDTO(saved.getIdConversa(), saved.getDataConversa(), clienteDTO);
    }

    public ConversaDTO ultimaConversa(UUID idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));

        List<Conversa> conversas = conversaRepository.findByCliente_IdClienteOrderByDataConversaDesc(idCliente);
        if (conversas.isEmpty()) return null;

        Conversa ultima = conversas.get(0);

        ClienteOutputDTO clienteOutputDTO = new ClienteOutputDTO(
                cliente.getIdCliente(),
                cliente.getLogin(),
                cliente.getName(),
                cliente.getTelefone()
        );

        return new ConversaDTO(ultima.getIdConversa(), ultima.getDataConversa(), clienteOutputDTO);
    }

    public MensagemDTO salvarMensagem(UUID idConversa, MensagemCreateDTO dto) {
        Conversa conversa = conversaRepository.findById(idConversa)
                .orElseThrow(() -> new RuntimeException("Conversa não encontrada"));

        if (!conversa.getCliente().getIdCliente().equals(dto.idCliente())) {
            throw new RuntimeException("Conversa não pertence ao cliente");
        }

        Mensagem msg = new Mensagem();
        msg.setConversa(conversa);
        msg.setRemetente(dto.remetente());
        msg.setConteudo_texto(dto.conteudo_texto());
        msg.setTimestamp(LocalDateTime.now());

        Mensagem saved = mensagemRepository.save(msg);

        String imagemBase64 = (saved.getImagem() != null)
                ? Base64.getEncoder().encodeToString(saved.getImagem())
                : null;

        return new MensagemDTO(
                saved.getId_mensagem(),
                saved.getRemetente(),
                saved.getConteudo_texto(),
                imagemBase64,
                saved.getTimestamp()

        );
    }

    public List<MensagemDTO> listarMensagens(UUID idConversa, UUID idCliente) {
        Conversa conversa = conversaRepository.findById(idConversa)
                .orElseThrow(() -> new RuntimeException("Conversa não encontrada"));

        if (!conversa.getCliente().getIdCliente().equals(idCliente)) {
            throw new RuntimeException("Conversa não pertence ao cliente");
        }

        return mensagemRepository.findByConversa_IdConversaOrderByTimestampAsc(idConversa)
                .stream()
                .map(m -> {
                    String img64 = (m.getImagem() != null)
                            ? Base64.getEncoder().encodeToString(m.getImagem())
                            : null;

                    return new MensagemDTO(
                            m.getId_mensagem(),
                            m.getRemetente(),
                            m.getConteudo_texto(),
                            img64,           // 4º = imagem
                            m.getTimestamp() // 5º = timestamp
                    );
                })
                .toList();
    }
}
