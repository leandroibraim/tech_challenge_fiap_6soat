package com.example.demo.adapter.outbound.integration.pagbank.response;

import com.example.demo.adapter.outbound.integration.pagbank.Link;
import com.example.demo.adapter.outbound.integration.pagbank.Total;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class QrCodeResponse {

    @JsonProperty("id")
    private String codigoQRCode;

    @JsonProperty("expiration_date")
    private String dataExpiracao;

    @JsonProperty("amount")
    private Total total;

    @JsonProperty("links")
    private List<Link> links;
}