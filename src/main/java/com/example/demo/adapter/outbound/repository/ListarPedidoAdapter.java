package com.example.demo.adapter.outbound.repository;

import com.example.demo.core.domain.Pedido;
import com.example.demo.core.ports.outbound.pedido.ListarPedidosAdapterPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ListarPedidoAdapter implements ListarPedidosAdapterPort {

    private PedidoRepository repository;

    @Autowired
    public ListarPedidoAdapter(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pedido> listarTodosPedidos() {
        List<String> listaStatus = Arrays.asList("RECEBIDO", "EM_PREPARACAO", "PRONTO", "FINALIZADO");
        List<Pedido> listaPedido = new ArrayList<>();

         listaStatus.forEach(item -> {
             listaPedido.addAll(
                     PedidoEntityMapper.INSTANCE.mapFrom(
                             repository.listarPedidosPorStatus(item, LocalDate.now())));
         });


        return listaPedido;
    }
}
