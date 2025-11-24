package com.example.backend_piscina.controllers;
import com.example.backend_piscina.dtos.MensagemDTO;
import com.example.backend_piscina.services.MensagemService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {

    private final MensagemService mensagemService;

    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    @PostMapping
    public MensagemDTO createMensagem(@RequestBody MensagemDTO dto) {
        return mensagemService.createMensagem(dto);
    }

    @GetMapping("/conversa/{idConversa}")
    public List<MensagemDTO> getMensagensByConversa(@PathVariable UUID idConversa) {
        return mensagemService.getMensagensByConversa(idConversa);
    }
}
