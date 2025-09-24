package com.example.backend_piscina.repositories;

import com.example.backend_piscina.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID>{
}

