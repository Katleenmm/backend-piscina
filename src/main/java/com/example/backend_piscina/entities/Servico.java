package com.example.backend_piscina.entities;

import com.example.backend_piscina.entities.enums.StatusServico;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idServico;

    @Column(nullable = false)
    private boolean concluido = false;

    private String descricao;
    private String endereco;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String resumoChat;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusServico status = StatusServico.PENDENTE;

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
        this.status = concluido ? StatusServico.CONCLUIDO : StatusServico.PENDENTE;
    }

    public void setStatus(StatusServico status) {
        this.status = status;
        this.concluido = (status == StatusServico.CONCLUIDO);
    }

    public UUID getIdServico() { return idServico; }
    public void setIdServico(UUID idServico) { this.idServico = idServico; }

    public boolean isConcluido() { return concluido; }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
        if (concluido) {
        this.status = StatusServico.CONCLUIDO;
        }
    }


    public StatusServico getStatus() { return status; }

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
