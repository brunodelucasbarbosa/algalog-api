package com.bruno.br.algalogapibrunodelucas.services;


import com.bruno.br.algalogapibrunodelucas.exceptionhandler.NegocioException;
import com.bruno.br.algalogapibrunodelucas.model.Entrega;
import com.bruno.br.algalogapibrunodelucas.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

  private EntregaRepository entregaRepository;

  public Entrega buscar(Long entregaId) {
    return entregaRepository.findById(entregaId)
            .orElseThrow(() -> new NegocioException("Entrega não encontrada!"));
  }
}
