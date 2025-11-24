package com.example.backend_piscina.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Mensagem")
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_mensagem;
    @ManyToOne
    @JoinColumn(name = "id_conversa")
    private Conversa conversa;
    private String remetente;
    private String conteudo_texto;
    private LocalDateTime timestamp;


    public UUID getId_mensagem() {
        return id_mensagem;
    }

    public void setId_mensagem(UUID id_mensagem) {
        this.id_mensagem = id_mensagem;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public Conversa getConversa() {
        return conversa;
    }

    public void setConversa(Conversa conversa) {
        this.conversa = conversa;
    }

    public String getConteudo_texto() {
        return conteudo_texto;
    }

    public void setConteudo_texto(String conteudo_texto) {
        this.conteudo_texto = conteudo_texto;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
