package com.bruno.br.algalogapibrunodelucas.services;

import com.bruno.br.algalogapibrunodelucas.model.Entrega;
import com.bruno.br.algalogapibrunodelucas.model.StatusEntrega;
import com.bruno.br.algalogapibrunodelucas.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class SolicitacaoEntregaService {

  private EntregaRepository entregaRepository;

  @Transactional
  public Entrega solicitar(Entrega entrega) {
    entrega.setStatus(StatusEntrega.PENDENTE);
    entrega.setDataPedido(LocalDateTime.now());

    return entregaRepository.save(entrega);
  }
}
