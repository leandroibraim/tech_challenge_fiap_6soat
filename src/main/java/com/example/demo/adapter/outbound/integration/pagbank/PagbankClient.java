package com.example.demo.adapter.outbound.integration.pagbank;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${pagbank.url}")
public interface PagbankClient {

    @PostMapping(value = "/orders", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void realizaPagamentoQRCodePix();

    @GetMapping(value = "/orders/{order_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void consultaStatusPagamento(@RequestParam String orderId);

}
