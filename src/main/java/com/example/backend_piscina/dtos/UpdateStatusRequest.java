package com.example.backend_piscina.dtos;

import com.example.backend_piscina.entities.enums.StatusServico;

public class UpdateStatusRequest {
    private StatusServico status;

    public StatusServico getStatus() { return status; }
    public void setStatus(StatusServico status) { this.status = status; }
}

