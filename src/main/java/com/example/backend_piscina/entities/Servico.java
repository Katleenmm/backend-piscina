package com.example.backend_piscina.entities;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idServico;

    private boolean concluido;
    private String descricao;
    private String endereco;

    // ✅ deixa só UMA vez (texto longo do resumo)
    @Lob
    @Column(columnDefinition = "TEXT")
    private String resumoChat;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_conversa")
    private Conversa conversa;

    public Servico() {}

    public Servico(boolean concluido, String descricao, String endereco, Cliente cliente) {
        this.concluido = concluido;
        this.descricao = descricao;
        this.endereco = endereco;
        this.cliente = cliente;
    }

    public UUID getIdServico() { return idServico; }
    public void setIdServico(UUID idServico) { this.idServico = idServico; }

    public boolean isConcluido() { return concluido; }
    public void setConcluido(boolean concluido) { this.concluido = concluido; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Conversa getConversa() { return conversa; }
    public void setConversa(Conversa conversa) { this.conversa = conversa; }

    public String getResumoChat() { return resumoChat; }
    public void setResumoChat(String resumoChat) { this.resumoChat = resumoChat; }
}
