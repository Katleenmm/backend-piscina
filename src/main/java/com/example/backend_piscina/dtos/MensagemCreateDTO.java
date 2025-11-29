package com.example.backend_piscina.dtos;

import java.util.UUID;

public record MensagemCreateDTO(
        UUID idCliente,
        String remetente,
        String conteudo_texto,
        String imagem
) {}
