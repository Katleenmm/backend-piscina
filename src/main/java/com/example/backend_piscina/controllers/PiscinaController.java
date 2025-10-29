package com.example.backend_piscina.controllers;

import com.example.backend_piscina.dtos.PiscinaDTO;
import com.example.backend_piscina.services.PiscinaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/piscina")
public class PiscinaController {
    private final PiscinaService piscinaService;

    public PiscinaController (PiscinaService piscinaService){
        this.piscinaService = piscinaService;
    }

    @GetMapping
    public Page<PiscinaDTO> getAllPiscina(Pageable pageable) {
        return piscinaService.getAllPiscina(pageable);
    }

    @GetMapping("/por-cliente/{id_cliente}")
    public List<PiscinaDTO> getAllPiscina(@PathVariable UUID id_cliente) {
        return piscinaService.getAllPiscinaPorCliente(id_cliente);
    }

    @GetMapping("/{id}")
    public PiscinaDTO getPiscinaById(@PathVariable UUID id) {
        return piscinaService.getPiscinaById(id);
    }

    @PostMapping
    public PiscinaDTO createPiscina(@RequestBody PiscinaDTO piscinaDTO) {
        return piscinaService.createPiscina(piscinaDTO);
    }

    @PutMapping("/{id}")
    public PiscinaDTO updatePiscina(@PathVariable UUID id, @RequestBody PiscinaDTO piscinaDTO){
        return piscinaService.updatePiscina(id, piscinaDTO);
    }

    @DeleteMapping("/{id}")
    public PiscinaDTO deletePiscina(@PathVariable UUID id) {
        return piscinaService.deletePiscina(id);
    }
}
