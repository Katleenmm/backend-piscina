package com.example.backend_piscina.dtos;

import java.util.UUID;

public record PiscinaDTO(
        UUID id_piscina,
        String medidas,
        ClienteDTO cliente
) {
}
