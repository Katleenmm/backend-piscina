package com.example.backend_piscina.services;

import com.example.backend_piscina.dtos.ServicoCreateDTO;
import com.example.backend_piscina.dtos.ServicoDTO;
import com.example.backend_piscina.entities.Cliente;
import com.example.backend_piscina.entities.Conversa;            
import com.example.backend_piscina.entities.Mensagem; 
import com.example.backend_piscina.repositories.ConversaRepository;
import com.example.backend_piscina.repositories.MensagemRepository;
import com.example.backend_piscina.entities.Servico;
import com.example.backend_piscina.mappers.ServicoMapper;
import com.example.backend_piscina.repositories.ClienteRepository;
import com.example.backend_piscina.repositories.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;
    private final ClienteRepository clienteRepository;
    private final ServicoMapper servicoMapper;
    private final ConversaRepository conversaRepository;
    private final MensagemRepository mensagemRepository;

    public ServicoService(ServicoRepository servicoRepository,
                          ClienteRepository clienteRepository,
                          ServicoMapper servicoMapper,
                          ConversaRepository conversaRepository,
                          MensagemRepository mensagemRepository) {
        this.servicoRepository = servicoRepository;
        this.clienteRepository = clienteRepository;
        this.servicoMapper = servicoMapper;
        this.conversaRepository = conversaRepository;
        this.mensagemRepository = mensagemRepository;
    }

    public Servico getById(UUID id) {
        return servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
    }

    public List<ServicoDTO> listarTodos() {
        return servicoRepository.findAll()
                .stream()
                .map(servicoMapper::toDTO)
                .toList();
    }

    public Servico updateConcluido(UUID id, boolean concluido) {
        Servico servico = getById(id);
        servico.setConcluido(concluido);
        return servicoRepository.save(servico);
    }

    public ServicoDTO create(ServicoCreateDTO dto) {

        Cliente cliente = clienteRepository.findById(dto.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Servico servico = servicoMapper.toEntity(dto, cliente);

        if (dto.getIdConversa() != null) {

            Conversa conversa = conversaRepository.findById(dto.getIdConversa())
                .orElseThrow(() -> new RuntimeException("Conversa não encontrada."));

            if (!conversa.getCliente().getIdCliente().equals(cliente.getIdCliente())) {
                throw new RuntimeException("Conversa não pertence ao cliente.");
            }

            servico.setConversa(conversa);

            List<Mensagem> msgs = mensagemRepository
                .findByConversa_IdConversaOrderByTimestampAsc(conversa.getIdConversa());

            String resumo = gerarResumoSimples(msgs);
            servico.setResumoChat(resumo);    
        }

        Servico saved = servicoRepository.save(servico);
        return servicoMapper.toDTO(saved);
    }
    
    public ServicoDTO getDTOById(UUID id) {
        Servico servico = getById(id);
        return servicoMapper.toDTO(servico);
    }

    public ServicoDTO updateConcluidoDTO(UUID id, boolean concluido) {
        Servico servico = getById(id);
        servico.setConcluido(concluido);
        Servico saved = servicoRepository.save(servico);
        return servicoMapper.toDTO(saved);
    }

    private String gerarResumoSimples(List<Mensagem> msgs) {
        int start = Math.max(0, msgs.size() - 30); //ultimas 30 mensagens
        StringBuilder sb = new StringBuilder();

        for (int i = start; i < msgs.size(); i++) {
            Mensagem m = msgs.get(i);

            String remetente = (m.getRemetente() == null) ? "desconhecido" : m.getRemetente();
            String texto = (m.getConteudo_texto() == null) ?  "" : m.getConteudo_texto();

            sb.append(remetente).append(": ").append(texto).append("\n");
        }

        String textoFinal = sb.toString();
        return textoFinal.length() > 2500 ? textoFinal.substring(0, 2500) + "..." : textoFinal;
    }
}
