package com.example.backend_piscina.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record ConversaDTO(
        UUID idConversa,
        LocalDateTime data_conversa,
        ClienteOutputDTO cliente
) {
}
