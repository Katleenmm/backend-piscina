package com.example.backend_piscina.repositories;
import com.example.backend_piscina.entities.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MensagemRepository extends JpaRepository<Mensagem, UUID> {
    List<Mensagem> findByConversa_IdConversaOrderByTimestampAsc(UUID idConversa);

}
