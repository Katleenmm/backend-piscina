package com.example.backend_piscina.mappers;
import com.example.backend_piscina.dtos.MensagemDTO;
import com.example.backend_piscina.entities.Mensagem;
import org.springframework.stereotype.Component;

@Component
public class MensagemMapper {

    public MensagemDTO toDTO(Mensagem mensagem) {
        return new MensagemDTO(
                mensagem.getId_mensagem(),
                mensagem.getConversa().getIdConversa(),
                mensagem.getRemetente(),
                mensagem.getConteudo_texto(),
                mensagem.getTimestamp()
        );
    }

    public Mensagem toEntity(MensagemDTO dto) {
        Mensagem mensagem = new Mensagem();

        mensagem.setId_mensagem(dto.id_mensagem());
        mensagem.setRemetente(dto.remetente());
        mensagem.setConteudo_texto(dto.conteudo_texto());
        mensagem.setTimestamp(dto.timestamp());

        return mensagem;
    }
}
