package com.example.backend_piscina.services;

import com.example.backend_piscina.dtos.ServicoDTO;
import com.example.backend_piscina.entities.Cliente;
import com.example.backend_piscina.entities.Servico;
import com.example.backend_piscina.mappers.ServicoMapper;
import com.example.backend_piscina.repositories.ClienteRepository;
import com.example.backend_piscina.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public ServicoDTO criarServico(ServicoDTO dto) {

        // valida cliente
        Cliente cliente = clienteRepository.findById(dto.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        // converte DTO → Entidade
        Servico servico = ServicoMapper.toEntity(dto, cliente);

        // salva no banco
        servicoRepository.save(servico);

        // converte Entidade → DTO
        return ServicoMapper.toDTO(servico);
    }
}
