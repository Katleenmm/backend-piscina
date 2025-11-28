package com.example.backend_piscina.dtos;

import java.util.UUID;

public class ServicoCreateDTO {

    private String descricao;
    private String endereco;
    private UUID idCliente;

    public String getDescricao() {
        return descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public UUID getIdCliente() {
        return idCliente;
    }
}
