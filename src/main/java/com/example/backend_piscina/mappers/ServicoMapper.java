package com.example.backend_piscina.mappers;

import com.example.backend_piscina.dtos.ClienteOutputDTO;
import com.example.backend_piscina.dtos.ServicoCreateDTO;
import com.example.backend_piscina.dtos.ServicoDTO;
import com.example.backend_piscina.entities.Cliente;
import com.example.backend_piscina.entities.Servico;
import org.springframework.stereotype.Component;

@Component
public class ServicoMapper {

    public ServicoDTO toDTO(Servico servico) {
        Cliente cliente = servico.getCliente();

        ClienteOutputDTO clienteDTO = new ClienteOutputDTO(
                cliente.getIdCliente(),
                cliente.getLogin(),
                cliente.getName(),
                cliente.getTelefone()
        );

        return new ServicoDTO(
                servico.getIdServico(),
                servico.isConcluido(),
                servico.getStatus(),
                servico.getDescricao(),
                servico.getEndereco(),
                servico.getConversa() != null ? servico.getConversa().getIdConversa() : null,
                servico.getResumoChat(),
                clienteDTO
        );
    }

    public Servico toEntity(ServicoCreateDTO dto, Cliente cliente) {
        Servico servico = new Servico();
        servico.setDescricao(dto.getDescricao());
        servico.setEndereco(dto.getEndereco());
        servico.setCliente(cliente);
        servico.setStatus(com.example.backend_piscina.entities.enums.StatusServico.PENDENTE); // ✅ default
        return servico;
    }
}
