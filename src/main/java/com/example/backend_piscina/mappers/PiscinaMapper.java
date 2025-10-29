package com.example.backend_piscina.mappers;

import com.example.backend_piscina.dtos.ClienteDTO;
import com.example.backend_piscina.dtos.PiscinaDTO;
import com.example.backend_piscina.entities.Cliente;
import com.example.backend_piscina.entities.Piscina;

public class PiscinaMapper {
    public PiscinaDTO toDTO(Piscina piscina) {
        return new PiscinaDTO(
                piscina.getId_piscina(),
                piscina.getMedidas(),
                new ClienteDTO(
                        piscina.getCliente().getId_cliente(),
                        piscina.getCliente().getName(),
                        piscina.getCliente().getEndereco(),
                        piscina.getCliente().getTelefone(),
                        piscina.getCliente().getDescricao()
                )
        );
    }

    public Piscina toEntity(PiscinaDTO dto){
        Cliente cliente = new Cliente();
        cliente.setId_cliente(dto.cliente().id_cliente());

        Piscina piscina = new Piscina();
        piscina.setId_piscina(dto.id_piscina());
        piscina.setMedidas(dto.medidas());
        piscina.setCliente(cliente);
        return piscina;
    }
}
