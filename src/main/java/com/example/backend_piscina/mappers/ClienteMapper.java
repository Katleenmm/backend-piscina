package com.example.backend_piscina.mappers;
import com.example.backend_piscina.dtos.ClienteDTO;
import com.example.backend_piscina.dtos.ClienteOutputDTO;
import com.example.backend_piscina.entities.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteOutputDTO toOutputDTO(Cliente cliente) {
        return new ClienteOutputDTO(
                cliente.getIdCliente(),
                cliente.getLogin(),
                cliente.getName(),
                cliente.getTelefone()
        );
    }

    public Cliente toEntity(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setLogin(dto.login());
        cliente.setSenha(dto.senha());
        cliente.setName(dto.name());
        cliente.setTelefone(dto.telefone());
        return cliente;
    }
}


