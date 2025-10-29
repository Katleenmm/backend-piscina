package com.example.backend_piscina.entities;

import jakarta.persistence.*;

import java.util.UUID;

public class Piscina {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_piscina;
    private String medidas;
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    public UUID getId_piscina() {
        return id_piscina;
    }

    public void setId_piscina(UUID id_piscina) {
        this.id_piscina = id_piscina;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
