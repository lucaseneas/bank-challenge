package com.example.bank.controllers.estatisticaController;

import com.example.bank.controllers.transacaoController.TransacaoController;
import com.example.bank.domain.transacao.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    @Autowired
    private TransacaoController transacaoController;

    @GetMapping
    public ResponseEntity estatisticasDoUltimoMinuto(){
        List<Transacao> listaDeTransacoes = transacaoController.listarTodasTransacoes();

        OffsetDateTime dataHoraAtual = OffsetDateTime.now();
        OffsetDateTime dataHoraAtualMenos = dataHoraAtual.minusSeconds(60);

        List<Transacao> listaDeTracoesEmSessentaSegundos = new ArrayList<>();

        for (Transacao transacao : listaDeTransacoes) {
            if(dataHoraAtualMenos.isBefore(transacao.getDataHora())){
                listaDeTracoesEmSessentaSegundos.add(transacao);
            }
        }

        DoubleSummaryStatistics estatisticas = listaDeTracoesEmSessentaSegundos.stream()
                .collect(Collectors.summarizingDouble(Transacao::getValor));

        return ResponseEntity.ok(estatisticas);
    }
}
