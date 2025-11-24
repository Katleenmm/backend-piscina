package com.example.backend_piscina.services;
import com.example.backend_piscina.dtos.ClienteDTO;
import com.example.backend_piscina.dtos.ClienteOutputDTO;
import com.example.backend_piscina.entities.Cliente;
import com.example.backend_piscina.mappers.ClienteMapper;
import com.example.backend_piscina.repositories.ClienteRepository;
import com.example.backend_piscina.repositories.PagamentoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class ClienteService {
    private final ClienteMapper clienteMapper;
    private final ClienteRepository clienteRepository;
    private final PagamentoRepository pagamentoRepository;
    private final PasswordEncoder passwordEncoder;

    public ClienteService(ClienteMapper clienteMapper, ClienteRepository clienteRepository, PagamentoRepository pagamentoRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.clienteMapper = clienteMapper;
        this.clienteRepository = clienteRepository;
        this.pagamentoRepository = pagamentoRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public Page<ClienteOutputDTO> getAllCliente(Pageable pageable) {
        Page<Cliente> clienteList = clienteRepository.findAll(pageable);
        return clienteList.map(clienteMapper::toOutputDTO);
    }

    public ClienteOutputDTO getClienteById(UUID id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("O cliente não existe")
        );
        return clienteMapper.toOutputDTO(cliente);
    }

    public ClienteOutputDTO createCliente(ClienteDTO dto) {
        Cliente cliente = clienteMapper.toEntity(dto);
        cliente.setLogin(dto.login());
        cliente.setSenha(passwordEncoder.encode(dto.senha()));
        cliente.setName(dto.name());
        cliente.setTelefone(dto.telefone());
        cliente.setEndereco(dto.endereco());
        cliente.setDescricao(dto.descricao());
        clienteRepository.save(cliente);
        return clienteMapper.toOutputDTO(cliente);
    }

    public ClienteOutputDTO updateCliente(UUID id, ClienteDTO dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O cliente não existe"));

        if (dto.senha() != null && !dto.senha().isBlank()) {
            cliente.setSenha(passwordEncoder.encode(dto.senha()));
        }
        if (dto.name() != null) cliente.setName(dto.name());
        if (dto.endereco() != null) cliente.setEndereco(dto.endereco());
        if (dto.telefone() != null) cliente.setTelefone(dto.telefone());
        if (dto.descricao() != null) cliente.setDescricao(dto.descricao());

        clienteRepository.save(cliente);

        return clienteMapper.toOutputDTO(cliente);
    }


    public void deleteCliente(UUID id_cliente) {
        // Verifica se cliente existe
        Cliente cliente = clienteRepository.findById(id_cliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        // Verifica se existe algum pagamento vinculado a esse cliente
        boolean hasPagamentos = pagamentoRepository.existsByCliente(cliente);
        if (hasPagamentos) {
            throw new RuntimeException("Não é possível apagar o cliente pois existem pagamentos vinculados.");
        }

        // Se não tiver pagamentos, apaga o cliente
        clienteRepository.delete(cliente);
    }
    @Configuration
    public class SecurityConfig {

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }
}
