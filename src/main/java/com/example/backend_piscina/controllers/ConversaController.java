package com.example.backend_piscina.controllers;
import com.example.backend_piscina.dtos.ConversaDTO;
import com.example.backend_piscina.services.ConversaService;
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

    @PostMapping("/{idCliente}")
    public ConversaDTO criateConversa(
            @PathVariable UUID idCliente
            ) {
        return conversaService.criateConversa(idCliente);
    }

    @GetMapping("/cliente/{idCliente}")
    public List<ConversaDTO> getByCliente(@PathVariable UUID idCliente) {
        return conversaService.getConversasById(idCliente);
    }
}
