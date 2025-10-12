package com.example.backend_piscina.controllers;

import com.example.backend_piscina.dtos.PagamentoDTO;
import com.example.backend_piscina.services.PagamentoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
    private final PagamentoService pagamentoService;

    public PagamentoController (PagamentoService pagamentoService){
        this.pagamentoService = pagamentoService;
    }

    @GetMapping
    public Page<PagamentoDTO> getAllPagamento(Pageable pageable) {
        return pagamentoService.getAllPagamento(pageable);
    }

    @GetMapping("/por-cliente/{id_cliente}")
    public List<PagamentoDTO> getAllPagamento(@PathVariable UUID id_cliente) {
        return pagamentoService.getAllPagamentoPorCliente(id_cliente);
    }

    @GetMapping("/{id}")
    public PagamentoDTO getPagamentoById(@PathVariable UUID id) {
        return pagamentoService.getPagamentoById(id);
    }

    @PostMapping
    public PagamentoDTO createPagamento(@RequestBody PagamentoDTO pagamentoDTO) {
        return pagamentoService.createPagamento(pagamentoDTO);
    }

    @PutMapping("/{id}")
    public PagamentoDTO updatePagamento(@PathVariable UUID id, @RequestBody PagamentoDTO pagamentoDTO){
        return pagamentoService.updatePagamento(id, pagamentoDTO);
    }

    @DeleteMapping("/{id}")
    public PagamentoDTO deletePagamento(@PathVariable UUID id) {
        return pagamentoService.deletePagamento(id);
    }
}
