package com.example.backend_piscina.controllers;

import com.example.backend_piscina.dtos.ServicoDTO;
import com.example.backend_piscina.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ServicoDTO criar(@RequestBody ServicoDTO dto) {
        return servicoService.criarServico(dto);
    }

    @GetMapping
    public List<ServicoDTO> listar() {
        return servicoService.listarServicos();
    }
}
