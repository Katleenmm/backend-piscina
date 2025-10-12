package com.example.backend_piscina.mappers;

import com.example.backend_piscina.dtos.ClienteDTO;
import com.example.backend_piscina.dtos.PagamentoDTO;
import com.example.backend_piscina.entities.Cliente;
import com.example.backend_piscina.entities.Pagamento;
import org.springframework.stereotype.Component;

@Component
public class PagamentoMapper {

    public PagamentoDTO toDTO(Pagamento pagamento) {
        return new PagamentoDTO(
                pagamento.getId_pagamento(),
                pagamento.getValor(),
                pagamento.getData_vencimento(),
                pagamento.isPago(),
                new ClienteDTO(
                        pagamento.getCliente().getId_cliente(),
                        pagamento.getCliente().getName(),
                        pagamento.getCliente().getEndereco(),
                        pagamento.getCliente().getTelefone()
                )
        );
    }

    public Pagamento toEntity(PagamentoDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setId_cliente(dto.cliente().id_cliente());

        Pagamento pagamento = new Pagamento();
        pagamento.setId_pagamento(dto.id_pagamento());
        pagamento.setValor(dto.valor());
        pagamento.setData_vencimento(dto.data_vencimento());
        pagamento.setPago(dto.pago());
        pagamento.setCliente(cliente);

        return pagamento;
    }
}
