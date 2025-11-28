package com.example.backend_piscina.controllers;

import com.example.backend_piscina.dtos.ServicoCreateDTO;
import com.example.backend_piscina.dtos.ServicoDTO;
import com.example.backend_piscina.entities.Servico;
import com.example.backend_piscina.services.ServicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    private final ServicoService servicoService;

    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    // LISTAR TODOS os serviços
    @GetMapping
    public ResponseEntity<List<ServicoDTO>> listarTodos() {
        return ResponseEntity.ok(servicoService.listarTodos());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Servico getById(@PathVariable UUID id) {
        return servicoService.getById(id);
    }

    // Criar
    @PostMapping
    public ResponseEntity<ServicoDTO> criar(@RequestBody ServicoCreateDTO dto) {
        ServicoDTO servico = servicoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(servico);
    }

    // Atualizar concluído
    @PatchMapping("/{id}/concluido")
    public Servico updateConcluido(
            @PathVariable UUID id,
            @RequestBody Map<String, Boolean> body
    ) {
        boolean concluido = body.get("concluido");
        return servicoService.updateConcluido(id, concluido);
    }
}
