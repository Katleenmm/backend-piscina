package com.example.backend_piscina.repositories;

import com.example.backend_piscina.entities.Piscina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PiscinaRepository extends JpaRepository<Piscina, UUID> {
}
