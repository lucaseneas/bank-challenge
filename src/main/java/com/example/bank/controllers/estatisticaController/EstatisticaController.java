package com.example.bank.controllers.estatisticaController;

import com.example.bank.controllers.transacaoController.TransacaoRepository;
import com.example.bank.controllers.transacaoController.TransacaoRequest;
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
    private TransacaoRepository transacaoRepository;

    @GetMapping
    public ResponseEntity<EstatisticaDTO> estatisticasDoUltimoMinuto(){
        OffsetDateTime dataHoraAtualMenos = OffsetDateTime.now().minusSeconds(60);

        List<TransacaoRequest> listaDeTracoesEmSessentaSegundos = new ArrayList<>();

        for (TransacaoRequest transacao : transacaoRepository.findAll()) {
            if(dataHoraAtualMenos.isBefore(transacao.getDataHora())){
                listaDeTracoesEmSessentaSegundos.add(transacao);
            }
        }

        DoubleSummaryStatistics estatisticas = listaDeTracoesEmSessentaSegundos.stream()
                .collect(Collectors.summarizingDouble(TransacaoRequest::getValor));

        return ResponseEntity.ok(new EstatisticaDTO(estatisticas));
    }

}
