package com.example.backend_piscina.repositories;

import com.example.backend_piscina.entities.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServicoRepository extends JpaRepository<Servico, UUID> {
}
