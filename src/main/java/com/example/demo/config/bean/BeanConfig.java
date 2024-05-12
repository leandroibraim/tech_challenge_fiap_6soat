package com.example.demo.config.bean;

import com.example.demo.core.ports.inbound.pedido.ListarPedidosUseCasePort;
import com.example.demo.core.usecase.ListarPedidosUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ListarPedidosUseCasePort listarPedidosUseCasePort() {
        return new ListarPedidosUseCase();
    }
}
