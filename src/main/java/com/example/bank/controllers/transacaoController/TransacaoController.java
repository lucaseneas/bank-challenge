package com.example.bank.controllers.transacaoController;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;


    @PostMapping
    public ResponseEntity adicionarTransacao(@Valid @RequestBody TransacaoRequest body){
            transacaoRepository.add(body);
            return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<TransacaoRequest> listarTodasTransacoes(){
        return transacaoRepository.findAll();
    }

    @DeleteMapping
    public ResponseEntity deletarTodasTrasacoes(){
        transacaoRepository.deleteAll();
        return ResponseEntity.ok().build();
    }

}
