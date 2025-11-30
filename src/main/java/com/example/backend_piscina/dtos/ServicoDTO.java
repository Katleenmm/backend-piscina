package com.example.backend_piscina.dtos;

import com.example.backend_piscina.entities.enums.StatusServico;
import java.util.UUID;

public class ServicoDTO {

    private UUID idServico;
    private boolean concluido;
    private StatusServico status; // ✅ NOVO (já estava no seu)
    private String descricao;
    private String endereco;
    private UUID idConversa;
    private String resumoChat;
    private ClienteOutputDTO cliente;

    public ServicoDTO() {}

    // ✅ MUDOU: adicionou StatusServico status como 3º parâmetro
    public ServicoDTO(UUID idServico,
                      boolean concluido,
                      StatusServico status,
                      String descricao,
                      String endereco,
                      UUID idConversa,
                      String resumoChat,
                      ClienteOutputDTO cliente) {
        this.idServico = idServico;
        this.concluido = concluido;
        this.status = status; // ✅ MUDOU: agora existe parâmetro status
        this.descricao = descricao;
        this.endereco = endereco;
        this.idConversa = idConversa;
        this.resumoChat = resumoChat;
        this.cliente = cliente;
    }

    public UUID getIdServico() { return idServico; }
    public boolean isConcluido() { return concluido; }
    public StatusServico getStatus() { return status; } // ✅ NOVO
    public String getDescricao() { return descricao; }
    public String getEndereco() { return endereco; }
    public UUID getIdConversa() { return idConversa; }
    public String getResumoChat() { return resumoChat; }
    public ClienteOutputDTO getCliente() { return cliente; }
}
