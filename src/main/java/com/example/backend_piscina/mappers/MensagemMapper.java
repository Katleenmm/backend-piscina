package com.example.backend_piscina.mappers;

import com.example.backend_piscina.dtos.MensagemDTO;
import com.example.backend_piscina.entities.Mensagem;
import org.springframework.stereotype.Component;
import java.util.Base64;

@Component
public class MensagemMapper {

    public MensagemDTO toDTO(Mensagem mensagem) {
        String imagemBase64 = null;
        if (mensagem.getImagem() != null) {
            imagemBase64 = Base64.getEncoder().encodeToString(mensagem.getImagem());
        }

        return new MensagemDTO(
                mensagem.getId_mensagem(),
                mensagem.getConversa().getIdConversa(),
                mensagem.getRemetente(),
                mensagem.getConteudo_texto(),
                imagemBase64,
                mensagem.getTimestamp()
        );
    }

    public Mensagem toEntity(MensagemDTO dto) {
        Mensagem mensagem = new Mensagem();

        mensagem.setId_mensagem(dto.id_mensagem());
        mensagem.setRemetente(dto.remetente());
        mensagem.setConteudo_texto(dto.conteudo_texto());
        mensagem.setTimestamp(dto.timestamp());

        if (dto.imagem() != null) {
            mensagem.setImagem(Base64.getDecoder().decode(dto.imagem()));
        }

        return mensagem;
    }
}
