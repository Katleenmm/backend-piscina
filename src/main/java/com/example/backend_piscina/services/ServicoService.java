package com.example.backend_piscina.services;

import com.example.backend_piscina.dtos.ServicoCreateDTO;
import com.example.backend_piscina.dtos.ServicoDTO;
import com.example.backend_piscina.entities.Cliente;
import com.example.backend_piscina.entities.Servico;
import com.example.backend_piscina.mappers.ServicoMapper;
import com.example.backend_piscina.repositories.ClienteRepository;
import com.example.backend_piscina.repositories.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;
    private final ClienteRepository clienteRepository;
    private final ServicoMapper servicoMapper;

    public ServicoService(ServicoRepository servicoRepository,
                          ClienteRepository clienteRepository,
                          ServicoMapper servicoMapper) {
        this.servicoRepository = servicoRepository;
        this.clienteRepository = clienteRepository;
        this.servicoMapper = servicoMapper;
    }

    public Servico getById(UUID id) {
        return servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
    }

    public List<ServicoDTO> listarTodos() {
        return servicoRepository.findAll()
                .stream()
                .map(servicoMapper::toDTO)
                .toList();
    }

    public Servico updateConcluido(UUID id, boolean concluido) {
        Servico servico = getById(id);
        servico.setConcluido(concluido);
        return servicoRepository.save(servico);
    }

    public ServicoDTO create(ServicoCreateDTO dto) {

        Cliente cliente = clienteRepository.findById(dto.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Servico servico = servicoMapper.toEntity(dto, cliente);

        Servico saved = servicoRepository.save(servico);

        return servicoMapper.toDTO(saved);
    }
}
