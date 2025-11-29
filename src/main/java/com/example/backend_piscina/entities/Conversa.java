package com.example.backend_piscina.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Conversa")
public class Conversa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_conversa")
    private UUID idConversa;
    private LocalDateTime dataConversa;
    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente cliente;


    public UUID getIdConversa() {
        return idConversa;
    }

    public void setIdConversa(UUID idConversa) {
        this.idConversa = idConversa;
    }

    public LocalDateTime getDataConversa() {
        return dataConversa;
    }

    public void setDataConversa(LocalDateTime dataConversa) {
        this.dataConversa = dataConversa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
