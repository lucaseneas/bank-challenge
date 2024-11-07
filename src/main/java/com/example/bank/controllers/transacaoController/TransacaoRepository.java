package com.example.bank.controllers.transacaoController;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    List<TransacaoRequest> listaTransacoes = new ArrayList<>();

    public void add(TransacaoRequest transacaoRequest){
        listaTransacoes.add(transacaoRequest);
    }

    public List<TransacaoRequest> findAll(){
        return listaTransacoes;
    }

    public void deleteAll(){
        listaTransacoes.clear();
    }



}
