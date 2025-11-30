package com.example.backend_piscina.controllers;

import com.example.backend_piscina.dtos.ServicoCreateDTO;
import com.example.backend_piscina.dtos.ServicoDTO;
import com.example.backend_piscina.dtos.UpdateStatusRequest;
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

    // Buscar por ID retornando DTO (com resumoChat)
    @GetMapping("/{id}")
    public ResponseEntity<ServicoDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(servicoService.getDTOById(id));
    }

    // LISTAR serviços por cliente (para "Minhas Solicitações")
    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<ServicoDTO>> listarPorCliente(@PathVariable UUID idCliente) {
        return ResponseEntity.ok(servicoService.listarPorCliente(idCliente));
    }


    // Criar
    @PostMapping
    public ResponseEntity<ServicoDTO> criar(@RequestBody ServicoCreateDTO dto) {
        ServicoDTO servico = servicoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(servico);
    }

    // Atualizar concluído retornando DTO
    @PatchMapping("/{id}/concluido")
    public ResponseEntity<ServicoDTO> updateConcluido(
            @PathVariable UUID id,
            @RequestBody Map<String, Boolean> body
    ) {
        boolean concluido = body.get("concluido");
        return ResponseEntity.ok(servicoService.updateConcluidoDTO(id, concluido));

    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ServicoDTO> atualizarStatus(
            @PathVariable UUID id,
            @RequestBody UpdateStatusRequest req
    ) {
        return ResponseEntity.ok(servicoService.atualizarStatusDTO(id, req.getStatus()));
    }
}
