package com.example.backend_piscina.repositories;

import com.example.backend_piscina.entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PagamentoRepository extends JpaRepository<Pagamento, UUID>{
}

