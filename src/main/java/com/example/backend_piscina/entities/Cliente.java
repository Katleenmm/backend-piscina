package com.example.backend_piscina.entities;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_cliente;
    private String name;
    private String endereco;
    private String telefone;

    public UUID getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(UUID id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
