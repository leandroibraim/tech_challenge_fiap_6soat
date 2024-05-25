package com.example.demo.adapter.outbound;

import com.example.demo.adapter.outbound.repository.PedidoRepository;
import com.example.demo.adapter.outbound.repository.entity.PedidoEntity;
import com.example.demo.core.ports.inbound.pedido.AlterarStatusPedidoEmPreparacaoUseCasePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AlterarStatusPedidoEmPreparacaoAdapter implements AlterarStatusPedidoEmPreparacaoUseCasePort {

    private final PedidoRepository pedidoRepository;

    @Override
    public void execute(Long idPedido) {
        PedidoEntity pedidoEntity = pedidoRepository.findById(idPedido).orElseThrow();
        pedidoEntity.setEtapa("EM_PREPARACAO");
        pedidoRepository.save(pedidoEntity);
    }
}
