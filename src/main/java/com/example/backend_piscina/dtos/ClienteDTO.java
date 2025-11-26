package com.example.backend_piscina.dtos;

import java.util.UUID;

public record ClienteDTO(
        UUID id_cliente,
        String login,
        String name,
        String senha,
        String telefone
) {
}

