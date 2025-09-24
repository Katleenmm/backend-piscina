package com.example.backend_piscina.mappers;

import com.example.backend_piscina.dtos.PagamentoDTO;
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
                pagamento.getCliente()
        );
    }

    public Pagamento toEntity(PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = new Pagamento();
        pagamento.setId_pagamento(pagamentoDTO.id_pagamento());
        pagamento.setValor(pagamentoDTO.valor());
        pagamento.setData_vencimento(pagamentoDTO.data_vencimento());
        pagamento.setPago(pagamentoDTO.pago());
        pagamento.setCliente(pagamentoDTO.cliente());
        return pagamento;
    }
}

