package com.example.backend_piscina.services;
import org.springframework.stereotype.Service;
import com.example.backend_piscina.dtos.MensagemDTO;
import com.example.backend_piscina.entities.Conversa;
import com.example.backend_piscina.entities.Mensagem;
import com.example.backend_piscina.mappers.MensagemMapper;
import com.example.backend_piscina.repositories.ConversaRepository;
import com.example.backend_piscina.repositories.MensagemRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MensagemService {

    private final MensagemRepository mensagemRepository;
    private final ConversaRepository conversaRepository;
    private final MensagemMapper mensagemMapper;

    public MensagemService(
            MensagemRepository mensagemRepository,
            ConversaRepository conversaRepository,
            MensagemMapper mensagemMapper) {

        this.mensagemRepository = mensagemRepository;
        this.conversaRepository = conversaRepository;
        this.mensagemMapper = mensagemMapper;
    }


    public MensagemDTO createMensagem(UUID idConversa, String remetente,
                                     String texto, byte[] imagem) {

        Conversa conversa = conversaRepository.findById(idConversa)
                .orElseThrow(() -> new RuntimeException("Conversa não encontrada"));

        Mensagem mensagem = new Mensagem();
        mensagem.setConversa(conversa);
        mensagem.setRemetente(remetente);
        mensagem.setConteudo_texto(texto);
        mensagem.setTimestamp(LocalDateTime.now());
        mensagem.setImagem(imagem);

        Mensagem salva = mensagemRepository.save(mensagem);

        return mensagemMapper.toDTO(salva);
    }

    public List<MensagemDTO> getMensagensByConversa(UUID idConversa) {

        List<Mensagem> mensagens = mensagemRepository.findByConversa_IdConversaOrderByTimestampAsc(idConversa);

        return mensagens.stream()
                .map(mensagemMapper::toDTO)
                .collect(Collectors.toList());
    }
}
