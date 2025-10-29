package com.example.backend_piscina.services;

import com.example.backend_piscina.dtos.PiscinaDTO;
import com.example.backend_piscina.entities.Cliente;
import com.example.backend_piscina.entities.Piscina;
import com.example.backend_piscina.mappers.PiscinaMapper;
import com.example.backend_piscina.repositories.ClienteRepository;
import com.example.backend_piscina.repositories.PiscinaRepository;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public class PiscinaService {
    private final PiscinaMapper piscinaMapper;
    private final PiscinaRepository piscinaRepository;
    private final ClienteRepository clienteRepository;

    public PiscinaService(PiscinaMapper piscinaMapper, PiscinaRepository piscinaRepository, ClienteRepository clienteRepository) {
        this.piscinaMapper = piscinaMapper;
        this.piscinaRepository = piscinaRepository;
        this.clienteRepository = clienteRepository;
    }

    public Page<PiscinaDTO> getAllPiscina(org.springframework.data.domain.Pageable pageable) {
        Page<Piscina> piscinaList = piscinaRepository.findAll(pageable);
        return piscinaList.map(piscinaMapper::toDTO);
    }

    public List<PiscinaDTO> getAllPiscinaPorCliente(UUID id_cliente) {
        List<Piscina> piscina = piscinaRepository.findAll();
        return piscina.stream().map(piscinaMapper::toDTO).toList();

    }

    public PiscinaDTO getPiscinaById(UUID id) {
        Piscina piscina = piscinaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Piscina não existe")
        );
        return piscinaMapper.toDTO(piscina);
    }

    public PiscinaDTO createPiscina(PiscinaDTO piscinaDTO) {
        Piscina piscina = piscinaMapper.toEntity(piscinaDTO);
        piscinaRepository.save(piscina);
        return piscinaMapper.toDTO(piscina);
    }

    public PiscinaDTO updatePiscina(UUID id, PiscinaDTO piscinaDTO) {
        Piscina piscina = piscinaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Esse pagamento não foi lançado no sistema")
        );
        UUID clienteId = piscinaDTO.cliente().id_cliente();
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(
                () -> new RuntimeException("Cliente não encontrado")
        );
        piscina.setMedidas(piscinaDTO.medidas());
        piscina.setCliente(cliente);

        piscinaRepository.save(piscina);

        return piscinaMapper.toDTO(piscina);
    }


    public PiscinaDTO deletePiscina(UUID id) {
        Piscina piscina = piscinaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Piscina não existente")
        );
        piscinaRepository.delete(piscina);
        return piscinaMapper.toDTO(piscina);
    }
}
