package com.example.demo.adapter.outbound;

import com.example.demo.adapter.inbound.controller.request.pedido.mapper.PedidoMapper;
import com.example.demo.adapter.outbound.repository.PedidoRepository;
import com.example.demo.adapter.outbound.repository.entity.PedidoEntity;
import com.example.demo.adapter.outbound.repository.mapper.PedidoEntityMapper;
import com.example.demo.core.domain.Pedido;
import com.example.demo.core.ports.inbound.pedido.PedidoEmPreparacaoUseCasePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PedidoEmPreparacaoAdapter implements PedidoEmPreparacaoUseCasePort {

    private final PedidoRepository pedidoRepository;

    @Override
    public Pedido execute(Long idPedido) {
        PedidoEntity pedidoEntity = pedidoRepository.findById(idPedido).orElseThrow();
        pedidoEntity.setEtapa("EM_PREPARACAO");
        PedidoEntity pedidoAlterado = pedidoRepository.save(pedidoEntity);
        return PedidoEntityMapper.INSTANCE.mapFrom(pedidoAlterado);
    }
}
