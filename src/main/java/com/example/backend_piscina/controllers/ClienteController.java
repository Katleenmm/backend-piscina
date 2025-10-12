package com.example.backend_piscina.controllers;

import com.example.backend_piscina.dtos.ClienteDTO;
import com.example.backend_piscina.services.ClienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping
    public Page<ClienteDTO> getAllCliente(Pageable pageable) {
        return clienteService.getAllCliente(pageable);
    }

    @GetMapping("/{id}")
    public ClienteDTO getClienteById(@PathVariable UUID id) {
        return clienteService.getClienteById(id);
    }

    @PostMapping
    public ClienteDTO createCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.createCliente(clienteDTO);
    }

    @PutMapping("/{id}")
    public ClienteDTO updateCliente(@PathVariable UUID id, @RequestBody ClienteDTO clienteDTO){
        return clienteService.updateCliente(id, clienteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable UUID id) {
        try {
            clienteService.deleteCliente(id);
            return ResponseEntity.ok().body("Cliente apagado com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
