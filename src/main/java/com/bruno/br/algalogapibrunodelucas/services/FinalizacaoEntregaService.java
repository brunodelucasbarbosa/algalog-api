package com.bruno.br.algalogapibrunodelucas.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

  private BuscaEntregaService buscaEntregaService;


  @Transactional
  public void finalizar(Long entregaId) {

  }
}
