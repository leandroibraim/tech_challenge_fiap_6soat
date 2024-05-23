package com.example.demo.adapter.inbound.controller.request.pagamento;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoRequest {

    @JsonProperty("id_pagamento")
    private Long idPagamento;

    @JsonProperty("tipo_do_pagamento")
    private String tipoDoPagamento;

}
