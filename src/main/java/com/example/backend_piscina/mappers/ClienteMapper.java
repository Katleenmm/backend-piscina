package com.example.backend_piscina.mappers;
import com.example.backend_piscina.dtos.ClienteDTO;
import com.example.backend_piscina.dtos.ClienteOutputDTO;
import com.example.backend_piscina.entities.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteOutputDTO toOutputDTO(Cliente cliente) {
        return new ClienteOutputDTO(
                cliente.getId_cliente(),
                cliente.getLogin(),
                cliente.getName(),
                cliente.getEndereco(),
                cliente.getTelefone(),
                cliente.getDescricao()
        );
    }

    public Cliente toEntity(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setLogin(dto.login());
        cliente.setSenha(dto.senha());
        cliente.setName(dto.name());
        cliente.setEndereco(dto.endereco());
        cliente.setTelefone(dto.telefone());
        cliente.setDescricao(dto.descricao());
        return cliente;
    }
}


