package com.example.bank.domain.transacao;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Date;

@Getter
@Setter
public class Transacao {
    @NotNull
    @Positive
    private Double valor;
    @NotNull
    @Past
    private OffsetDateTime dataHora;
}
