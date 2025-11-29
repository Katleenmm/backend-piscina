package com.example.backend_piscina.repositories;

import com.example.backend_piscina.entities.Conversa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ConversaRepository extends JpaRepository<Conversa, UUID> {
    List<Conversa> findByCliente_IdClienteOrderByDataConversaDesc(UUID idCliente);

}
