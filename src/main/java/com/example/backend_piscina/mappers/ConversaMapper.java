package com.example.backend_piscina.mappers;
import com.example.backend_piscina.dtos.ClienteOutputDTO;
import com.example.backend_piscina.dtos.ConversaDTO;
import com.example.backend_piscina.entities.Cliente;
import com.example.backend_piscina.entities.Conversa;
import org.springframework.stereotype.Component;

@Component
public class ConversaMapper {
    public ConversaDTO toDTO(Conversa conversa) {
        return new ConversaDTO(
                conversa.getIdConversa(),
                conversa.getDataConversa(),

                new ClienteOutputDTO(
                        conversa.getCliente().getIdCliente(),
                        conversa.getCliente().getLogin(),
                        conversa.getCliente().getName(),
                        conversa.getCliente().getTelefone()

                )
        );
    }

    public Conversa toEntity(ConversaDTO dto){
        Cliente cliente = new Cliente();
        cliente.setIdCliente(dto.cliente().id());

        Conversa conversa = new Conversa();
        conversa.setIdConversa(dto.idConversa());
        conversa.setDataConversa(dto.data_conversa());
        conversa.setCliente(cliente);
        return conversa;
    }
}
