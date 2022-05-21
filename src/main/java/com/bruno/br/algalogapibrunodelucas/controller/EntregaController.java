package com.bruno.br.algalogapibrunodelucas.controller;


import com.bruno.br.algalogapibrunodelucas.model.Entrega;
import com.bruno.br.algalogapibrunodelucas.services.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EntregaController {

  private SolicitacaoEntregaService solicitacaoEntregaService;

  @PostMapping("/entregas")
  @ResponseStatus(HttpStatus.CREATED)
  public Entrega criar(@RequestBody Entrega entrega) {
    return solicitacaoEntregaService.solicitar(entrega);
  }
}
