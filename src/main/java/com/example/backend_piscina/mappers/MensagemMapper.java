package com.example.backend_piscina.mappers;

import com.example.backend_piscina.dtos.MensagemCreateDTO;
import com.example.backend_piscina.dtos.MensagemDTO;
import com.example.backend_piscina.entities.Conversa;
import com.example.backend_piscina.entities.Mensagem;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Base64;

@Component
public class MensagemMapper {

    public MensagemDTO toDTO(Mensagem mensagem) {
        String imagemBase64 = (mensagem.getImagem() != null)
        ? Base64.getEncoder().encodeToString(mensagem.getImagem())
        : null;

        return new MensagemDTO(
                mensagem.getId_mensagem(),
                mensagem.getRemetente(),
                mensagem.getConteudo_texto(),
                imagemBase64,
                mensagem.getTimestamp()
        );
    }

    public Mensagem toEntity(MensagemCreateDTO dto, Conversa conversa) {
        Mensagem mensagem = new Mensagem();

        mensagem.setConversa(conversa);
        mensagem.setRemetente(dto.remetente());
        mensagem.setConteudo_texto(dto.conteudo_texto());
        mensagem.setTimestamp(LocalDateTime.now());

        if (dto.imagem() != null) {
            mensagem.setImagem(Base64.getDecoder().decode(dto.imagem()));
        }

        return mensagem;
    }
}
