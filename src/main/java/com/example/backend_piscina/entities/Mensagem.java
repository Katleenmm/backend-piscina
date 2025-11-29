package com.example.backend_piscina.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "mensagem")
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_mensagem", updatable = false, nullable = false)
    private UUID id_mensagem;
    @ManyToOne
    @JoinColumn(name = "id_conversa")
    private Conversa conversa;
    @Column(name = "remetente")
    private String remetente;
    @Column(name = "conteudo_texto")
    private String conteudo_texto;
    @Lob
    @JdbcTypeCode(SqlTypes.BINARY)
    @Column(name = "imagem", columnDefinition = "bytea")
    private byte[] imagem;
    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    public UUID getId_mensagem() {
        return id_mensagem;
    }

    public void setId_mensagem(UUID id_mensagem) {
        this.id_mensagem = id_mensagem;
    }

    public Conversa getConversa() {
        return conversa;
    }

    public void setConversa(Conversa conversa) {
        this.conversa = conversa;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getConteudo_texto() {
        return conteudo_texto;
    }

    public void setConteudo_texto(String conteudo_texto) {
        this.conteudo_texto = conteudo_texto;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }


}


