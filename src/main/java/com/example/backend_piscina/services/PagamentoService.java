package com.example.backend_piscina.services;

import com.example.backend_piscina.dtos.PagamentoDTO;
import com.example.backend_piscina.entities.Cliente;
import com.example.backend_piscina.entities.Pagamento;
import com.example.backend_piscina.mappers.PagamentoMapper;
import com.example.backend_piscina.repositories.ClienteRepository;
import com.example.backend_piscina.repositories.PagamentoRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class PagamentoService {
    private final PagamentoMapper pagamentoMapper;
    private final PagamentoRepository pagamentoRepository;
    private final ClienteRepository clienteRepository;

    public PagamentoService(PagamentoMapper pagamentoMapper, PagamentoRepository pagamentoRepository, ClienteRepository clienteRepository) {
        this.pagamentoMapper = pagamentoMapper;
        this.pagamentoRepository = pagamentoRepository;
        this.clienteRepository = clienteRepository;
    }

    public Page<PagamentoDTO> getAllPagamento(org.springframework.data.domain.Pageable pageable) {
        Page<Pagamento> pagamentoList = pagamentoRepository.findAll(pageable);
        return pagamentoList.map(pagamentoMapper::toDTO);
    }

    public List<PagamentoDTO> getAllPagamentoPorCliente(UUID id_cliente) {
        List<Pagamento> pagamentos = pagamentoRepository.findAll();
        return pagamentos.stream().map(pagamentoMapper::toDTO).toList();

    }

    public PagamentoDTO getPagamentoById(UUID id) {
        Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("O pagamento não existe")
        );
        return pagamentoMapper.toDTO(pagamento);
    }

    public PagamentoDTO createPagamento(PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = pagamentoMapper.toEntity(pagamentoDTO);
        pagamentoRepository.save(pagamento);
        return pagamentoMapper.toDTO(pagamento);
    }

    public PagamentoDTO updatePagamento(UUID id, PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Esse pagamento não foi lançado no sistema")
        );
        UUID clienteId = pagamentoDTO.cliente().id_cliente();
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(
                () -> new RuntimeException("Cliente não encontrado")
        );
        pagamento.setValor(pagamentoDTO.valor());
        pagamento.setData_vencimento(pagamentoDTO.data_vencimento());
        pagamento.setPago(pagamentoDTO.pago());
        pagamento.setCliente(cliente);

        pagamentoRepository.save(pagamento);

        return pagamentoMapper.toDTO(pagamento);
    }


    public PagamentoDTO deletePagamento(UUID id) {
        Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Pagamento não existente")
        );
        pagamentoRepository.delete(pagamento);
        return pagamentoMapper.toDTO(pagamento);
    }

}

