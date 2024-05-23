package com.example.demo.adapter.outbound.integration;

import com.example.demo.adapter.outbound.repository.PagamentoRepository;
import com.example.demo.adapter.outbound.repository.entity.PagamentoEntity;
import com.example.demo.adapter.outbound.repository.mapper.PagamentoEntityMapper;
import com.example.demo.core.domain.Pagamento;
import com.example.demo.core.ports.outbound.pagamento.SalvarPagamentoAdapterPort;
import org.springframework.stereotype.Component;

@Component
public class SalvarPagamentoAdapter implements SalvarPagamentoAdapterPort {

    private final PagamentoRepository pagamentoRepository;
    private final PagamentoEntityMapper pagamentoEntityMapper;

    public SalvarPagamentoAdapter(PagamentoRepository pagamentoRepository, PagamentoEntityMapper pagamentoEntityMapper) {
        this.pagamentoRepository = pagamentoRepository;
        this.pagamentoEntityMapper = pagamentoEntityMapper;
    }

    @Override
    public void salvar(Pagamento pagamento) {
        PagamentoEntity pagamentoEntity = pagamentoEntityMapper.mapFrom(pagamento);
        pagamentoRepository.save(pagamentoEntity);
    }
}
