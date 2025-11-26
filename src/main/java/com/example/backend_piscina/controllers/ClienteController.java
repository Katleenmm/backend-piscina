package com.example.backend_piscina.controllers;

import com.example.backend_piscina.dtos.ClienteDTO;
import com.example.backend_piscina.dtos.ClienteLoginDTO;
import com.example.backend_piscina.dtos.ClienteOutputDTO;
import com.example.backend_piscina.entities.Cliente;
import com.example.backend_piscina.repositories.ClienteRepository;
import com.example.backend_piscina.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteController(ClienteService clienteService, ClienteRepository clienteRepository){
        this.clienteService = clienteService;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public Page<ClienteOutputDTO> getAllCliente(Pageable pageable) {
        return clienteService.getAllCliente(pageable);
    }

    @GetMapping("/{id}")
    public ClienteOutputDTO getClienteById(@PathVariable UUID id) {
        return clienteService.getClienteById(id);
    }

    @PostMapping("/login")
    public ResponseEntity<ClienteLoginDTO> login(@RequestBody Map<String, String> loginRequest) {
        String login = loginRequest.get("login");
        String senha = loginRequest.get("senha");

        Optional<Cliente> cliente = clienteRepository.findByLoginAndSenha(login, senha);

        if (cliente.isPresent()) {
            Cliente c = cliente.get();

            ClienteLoginDTO dto = new ClienteLoginDTO(
                    c.getIdCliente(),
                    c.getName(),
                    c.getLogin()
            );

            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }



    @PostMapping
    public ResponseEntity<?> cadastrarCliente(@RequestBody Cliente cliente) {
        // Você pode adicionar validações básicas
        if (cliente.getLogin() == null || cliente.getSenha() == null) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Login e senha são obrigatórios"));
        }

        // Salva no banco
        Cliente salvo = clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ClienteOutputDTO updateCliente(@PathVariable UUID id, @RequestBody ClienteDTO clienteDTO){
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
