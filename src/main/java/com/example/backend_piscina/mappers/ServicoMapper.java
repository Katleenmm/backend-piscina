package com.example.backend_piscina.mappers;

import com.example.backend_piscina.dtos.ServicoDTO;
import com.example.backend_piscina.entities.Cliente;
import com.example.backend_piscina.entities.Servico;

public class ServicoMapper {

    public static Servico toEntity(ServicoDTO dto, Cliente cliente) {
        Servico servico = new Servico();
        servico.setDescricao(dto.getDescricao());
        servico.setEndereco(dto.getEndereco());
        servico.setCliente(cliente);
        return servico;
    }

    public static ServicoDTO toDTO(Servico servico) {
        ServicoDTO dto = new ServicoDTO();
        dto.setIdServico(servico.getIdServico());
        dto.setDescricao(servico.getDescricao());
        dto.setEndereco(servico.getEndereco());
        dto.setIdCliente(servico.getCliente().getIdCliente());
        return dto;
    }
}
