package com.example.backend_piscina.dtos;

import java.util.UUID;

public class ClienteLoginDTO {

    private UUID idCliente;
    private String name;
    private String login;

    public ClienteLoginDTO() {}

    public ClienteLoginDTO(UUID idCliente, String name, String login) {
        this.idCliente = idCliente;
        this.name = name;
        this.login = login;
    }

    public UUID getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
