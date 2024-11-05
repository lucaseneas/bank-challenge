package com.example.bank.domain.transacao;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.util.Date;


public record TransacaoRequest(@NotNull Double valor, @NotNull  Date dataHora) {
}
