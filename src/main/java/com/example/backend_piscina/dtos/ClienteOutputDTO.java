package com.example.backend_piscina.dtos;

import java.util.UUID;

public record ClienteOutputDTO(
        UUID id,
        String login,
        String name,
        String endereco,
        String telefone,
        String descricao) {
}
