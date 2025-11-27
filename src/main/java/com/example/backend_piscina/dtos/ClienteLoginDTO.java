package com.example.backend_piscina.dtos;

import java.util.UUID;

public class ClienteLoginDTO {

    private UUID idCliente;
    private String name;
    private String login;
    private String role; // <--- campo novo

    public ClienteLoginDTO(UUID idCliente, String name, String login, String role) {
        this.idCliente = idCliente;
        this.name = name;
        this.login = login;
        this.role = role;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
