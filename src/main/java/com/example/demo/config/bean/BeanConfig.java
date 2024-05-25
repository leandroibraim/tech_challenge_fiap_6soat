package com.example.demo.config.bean;

import com.example.demo.core.ports.inbound.cliente.IncluirClienteUseCasePort;
import com.example.demo.core.ports.inbound.cliente.RecuperarClienteUseCasePort;
import com.example.demo.core.ports.inbound.pagamento.PagarPedidoUseCasePort;
import com.example.demo.core.ports.inbound.pedido.AlterarStatusPedidoEmPreparacaoUseCasePort;
import com.example.demo.core.ports.inbound.pedido.ListarPedidosUseCasePort;
import com.example.demo.core.ports.inbound.pedido.SalvarPedidoUseCasePort;
import com.example.demo.core.ports.inbound.produto.GerenciarProdutoUseCasePort;
import com.example.demo.core.ports.outbound.cliente.IncluirClienteAdapterPort;
import com.example.demo.core.ports.outbound.cliente.RecuperarClienteAdapterPort;
import com.example.demo.core.ports.outbound.pagamento.PagarPedidoAdapterPort;
import com.example.demo.core.ports.outbound.pagamento.SalvarPagamentoAdapterPort;
import com.example.demo.core.ports.outbound.pedido.ListarPedidosAdapterPort;
import com.example.demo.core.ports.outbound.pedido.SalvarPedidoAdapterPort;
import com.example.demo.core.ports.outbound.produto.GerenciarProdutoAdapterPort;
import com.example.demo.core.usecase.GerenciarProdutoUseCase;
import com.example.demo.core.usecase.IncluirClienteUseCase;
import com.example.demo.core.usecase.ListarPedidosUseCase;
import com.example.demo.core.usecase.PagarPedidoUseCase;
import com.example.demo.core.usecase.RecuperarClienteUseCase;
import com.example.demo.core.usecase.SalvarPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public IncluirClienteUseCasePort incluirClienteUseCasePort(IncluirClienteAdapterPort incluirClienteAdapterPort) {
        return new IncluirClienteUseCase(incluirClienteAdapterPort);
    }

    @Bean
    public RecuperarClienteUseCasePort recuperarClienteUseCasePort(RecuperarClienteAdapterPort recuperarClienteAdapterPort) {
        return new RecuperarClienteUseCase(recuperarClienteAdapterPort);
    }

    @Bean
    public ListarPedidosUseCasePort listarPedidosUseCasePort(ListarPedidosAdapterPort listarPedidosAdapterPort) {
        return new ListarPedidosUseCase(listarPedidosAdapterPort);
    }

    @Bean
    public SalvarPedidoUseCasePort salvarPedidoUseCasePort(SalvarPedidoAdapterPort salvarPedidoAdapterPort, GerenciarProdutoAdapterPort gerenciarProdutoAdapterPort) {
        return new SalvarPedidoUseCase(salvarPedidoAdapterPort, gerenciarProdutoAdapterPort);
    }

    @Bean
    public GerenciarProdutoUseCasePort incluirProdutoUseCasePort(GerenciarProdutoAdapterPort gerenciarProdutoAdapterPort) {
        return new GerenciarProdutoUseCase(gerenciarProdutoAdapterPort);
    }

    @Bean
    public PagarPedidoUseCasePort pagarPedidoUseCasePort(PagarPedidoAdapterPort pagarPedidoAdapterPort, SalvarPagamentoAdapterPort salvarPagamentoAdapterPort, AlterarStatusPedidoEmPreparacaoUseCasePort alterarStatusPedidoEmPreparacaoUseCasePort) {
        return new PagarPedidoUseCase(pagarPedidoAdapterPort, salvarPagamentoAdapterPort, alterarStatusPedidoEmPreparacaoUseCasePort);
    }
}
