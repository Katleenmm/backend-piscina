package com.example.backend_piscina.repositories;

import com.example.backend_piscina.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    // Busca pelo login e senha (texto puro)
    Optional<Cliente> findByLoginAndSenha(String login, String senha);

    // Caso queira verificar se o login já existe no cadastro
    boolean existsByLogin(String login);
}
