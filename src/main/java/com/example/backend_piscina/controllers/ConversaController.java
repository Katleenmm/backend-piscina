package com.example.backend_piscina.controllers;
import com.example.backend_piscina.dtos.ConversaCreateDTO;
import com.example.backend_piscina.dtos.ConversaDTO;
import com.example.backend_piscina.dtos.MensagemCreateDTO;
import com.example.backend_piscina.dtos.MensagemDTO;
import com.example.backend_piscina.services.ConversaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/conversas")
public class ConversaController {

    private final ConversaService conversaService;

    public ConversaController(ConversaService conversaService) {
        this.conversaService = conversaService;
    }

    @PostMapping("/conversas")
    public ResponseEntity<ConversaDTO> criarConversa(@RequestBody ConversaCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(conversaService.criarConversa(dto));
    }

    // ✅ pega última conversa do cliente (pra continuar histórico)
    @GetMapping("/clientes/{idCliente}/conversas/ultima")
    public ResponseEntity<ConversaDTO> ultima(@PathVariable UUID idCliente) {
        return ResponseEntity.ok(conversaService.ultimaConversa(idCliente));
    }

    // ✅ salva mensagem
    @PostMapping("/conversas/{idConversa}/mensagens")
    public ResponseEntity<MensagemDTO> salvar(@PathVariable UUID idConversa,
                                              @RequestBody MensagemCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(conversaService.salvarMensagem(idConversa, dto));
    }

    // ✅ lista mensagens
    @GetMapping("/conversas/{idConversa}/mensagens")
    public ResponseEntity<List<MensagemDTO>> listar(@PathVariable UUID idConversa,
                                                    @RequestParam UUID idCliente) {
        return ResponseEntity.ok(conversaService.listarMensagens(idConversa, idCliente));
    }
}
