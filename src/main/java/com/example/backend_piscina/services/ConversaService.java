package com.example.backend_piscina.services;
import org.springframework.stereotype.Service;
import com.example.backend_piscina.dtos.ConversaDTO;
import com.example.backend_piscina.entities.Cliente;
import com.example.backend_piscina.entities.Conversa;
import com.example.backend_piscina.mappers.ConversaMapper;
import com.example.backend_piscina.repositories.ClienteRepository;
import com.example.backend_piscina.repositories.ConversaRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ConversaService {

    private final ConversaRepository conversaRepository;
    private final ClienteRepository clienteRepository;
    private final ConversaMapper conversaMapper;

    public ConversaService(
            ConversaRepository conversaRepository,
            ClienteRepository clienteRepository,
            ConversaMapper conversaMapper) {

        this.conversaRepository = conversaRepository;
        this.clienteRepository = clienteRepository;
        this.conversaMapper = conversaMapper;
    }

    public ConversaDTO criateConversa(UUID id) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Conversa conversa = new Conversa();
        conversa.setCliente(cliente);
        conversa.setData_conversa(LocalDateTime.now());
        Conversa salva = conversaRepository.save(conversa);

        return conversaMapper.toDTO(salva);
    }

    public List<ConversaDTO> getConversasById(UUID idCliente) {

        List<Conversa> conversas = conversaRepository.findByCliente_idCliente(idCliente);

        return conversas.stream()
                .map(conversaMapper::toDTO)
                .collect(Collectors.toList());
    }

}
