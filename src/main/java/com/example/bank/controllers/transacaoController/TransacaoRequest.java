package com.example.bank.controllers.transacaoController;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class TransacaoRequest{
        @NotNull @Positive
        private Double valor;
        @NotNull @Past
        private OffsetDateTime dataHora;
}
