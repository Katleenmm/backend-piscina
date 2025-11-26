package com.example.backend_piscina.dtos;

import java.util.UUID;

public class ServicoDTO {

    private UUID idServico;   // pode vir nulo no POST
    private String descricao;
    private String endereco;
    private UUID idCliente;

    public UUID getIdServico() {
        return idServico;
    }

    public void setIdServico(UUID idServico) {
        this.idServico = idServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public UUID getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
    }
}
