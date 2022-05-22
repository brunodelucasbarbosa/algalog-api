package com.bruno.br.algalogapibrunodelucas.services;

import com.bruno.br.algalogapibrunodelucas.exceptionhandler.NegocioException;
import com.bruno.br.algalogapibrunodelucas.model.Cliente;
import com.bruno.br.algalogapibrunodelucas.model.Entrega;
import com.bruno.br.algalogapibrunodelucas.model.StatusEntrega;
import com.bruno.br.algalogapibrunodelucas.repository.ClienteRepository;
import com.bruno.br.algalogapibrunodelucas.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class SolicitacaoEntregaService {

  private EntregaRepository entregaRepository;
  private CatalogoClienteService catalogoClienteService;

  @Transactional
  public Entrega solicitar(Entrega entrega) {
    Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

    entrega.setCliente(cliente);
    entrega.setStatus(StatusEntrega.PENDENTE);
    entrega.setDataPedido(OffsetDateTime.now());

    return entregaRepository.save(entrega);
  }
}
