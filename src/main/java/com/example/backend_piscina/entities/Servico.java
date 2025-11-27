package com.example.backend_piscina.entities;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idServico;

    private String descricao;
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "id_cliente") // chave estrangeira
    private Cliente cliente;

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
