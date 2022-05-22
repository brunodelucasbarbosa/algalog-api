package com.bruno.br.algalogapibrunodelucas.services;

import com.bruno.br.algalogapibrunodelucas.exceptionhandler.NegocioException;
import com.bruno.br.algalogapibrunodelucas.model.Entrega;
import com.bruno.br.algalogapibrunodelucas.model.StatusEntrega;
import com.bruno.br.algalogapibrunodelucas.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

  private BuscaEntregaService buscaEntregaService;
  private EntregaRepository entregaRepository;

  @Transactional
  public void finalizar(Long entregaId) {
    Entrega entrega = buscaEntregaService.buscar(entregaId);

    entrega.finalizar();

    entregaRepository.save(entrega);
  }
}
