package com.example.backend_piscina.dtos;

import java.util.UUID;

public class ServicoDTO {

    private UUID idServico;
    private boolean concluido;
    private String descricao;
    private String endereco;
    private ClienteOutputDTO cliente;  // ⬅ TROCAR AQUI

    public ServicoDTO() {}

    public ServicoDTO(UUID idServico, boolean concluido, String descricao,
                      String endereco, ClienteOutputDTO cliente) { // ⬅ TROCAR AQUI
        this.idServico = idServico;
        this.concluido = concluido;
        this.descricao = descricao;
        this.endereco = endereco;
        this.cliente = cliente;
    }

    public UUID getIdServico() { return idServico; }
    public boolean isConcluido() { return concluido; }
    public String getDescricao() { return descricao; }
    public String getEndereco() { return endereco; }
    public ClienteOutputDTO getCliente() { return cliente; }  // ⬅ TROCAR AQUI
}
