package com.example.backend_piscina.dtos;
import java.time.LocalDateTime;
import java.util.UUID;


public record MensagemDTO(
        UUID id_mensagem,
        String remetente,
        String conteudo_texto,
        String imagem,
        LocalDateTime timestamp
) {}
