package com.example.demo.adapter.inbound.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDTO {

    @NotBlank(message = "CPF não preenchido.")
    @JsonProperty("cpf_cliente")
    private String cpf;

    @NotBlank(message = "Nome não preenchido.")
    @JsonProperty("nome_cliente")
    private String nome;

    @NotBlank(message = "E-mail não preenchido.")
    @JsonProperty("email_cliente")
    private String email;

    @NotBlank(message = "Telefone não preenchido.")
    @JsonProperty("telefone_cliente")
    private String telefone;
}
