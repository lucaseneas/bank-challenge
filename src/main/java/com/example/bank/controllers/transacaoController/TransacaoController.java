package com.example.bank.controllers.transacaoController;

import com.example.bank.domain.transacao.Transacao;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    private List<Transacao> listaTransacoes =  new ArrayList<>();

    @PostMapping
    public ResponseEntity<Transacao> fazerTransacao(@Valid @RequestBody Transacao body){
            listaTransacoes.add(body);
            return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<Transacao> listarTodasTransacoes(){
        return listaTransacoes;
    }

    @DeleteMapping
    public ResponseEntity deletarTodasTrasacoes(){
        listaTransacoes.clear();
        return ResponseEntity.ok().build();
    }

}
