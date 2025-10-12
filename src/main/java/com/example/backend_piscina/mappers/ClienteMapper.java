package com.example.backend_piscina.mappers;

import com.example.backend_piscina.dtos.ClienteDTO;
import com.example.backend_piscina.entities.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    public ClienteDTO toDTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getId_cliente(),
                cliente.getName(),
                cliente.getEndereco(),
                cliente.getTelefone()
        );
    }

    public Cliente toEntity(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setId_cliente(clienteDTO.id_cliente());
        cliente.setName(clienteDTO.name());
        cliente.setEndereco(clienteDTO.endereco());
        cliente.setTelefone(clienteDTO.telefone());
        return cliente;
    }
}

