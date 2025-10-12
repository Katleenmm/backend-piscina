package com.example.backend_piscina.dtos;

import com.example.backend_piscina.entities.Cliente;

import java.time.LocalDate;
import java.util.UUID;

public record PagamentoDTO (
        UUID id_pagamento,
        double valor,
        LocalDate data_vencimento,
        boolean pago,
        ClienteDTO cliente
){
}
