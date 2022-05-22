package com.bruno.br.algalogapibrunodelucas.controller;


import com.bruno.br.algalogapibrunodelucas.dto.DestinatarioModel;
import com.bruno.br.algalogapibrunodelucas.dto.EntregaModel;
import com.bruno.br.algalogapibrunodelucas.dto.input.EntregaInputModel;
import com.bruno.br.algalogapibrunodelucas.mapper.EntregaAssembler;
import com.bruno.br.algalogapibrunodelucas.model.Entrega;
import com.bruno.br.algalogapibrunodelucas.repository.EntregaRepository;
import com.bruno.br.algalogapibrunodelucas.services.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class EntregaController {

  private SolicitacaoEntregaService solicitacaoEntregaService;
  private EntregaRepository entregaRepository;
  private EntregaAssembler entregaAssembler;

  @PostMapping("/entregas")
  @ResponseStatus(HttpStatus.CREATED)
  public EntregaModel solicitar(@Valid @RequestBody EntregaInputModel entregaInputModel) {
    Entrega novaEntrega = entregaAssembler.toEntity(entregaInputModel);

    Entrega entregaFeita = solicitacaoEntregaService.solicitar(novaEntrega);

    return entregaAssembler.toModel(entregaFeita);
  }

  @GetMapping("/entregas")
  public List<EntregaModel> listar() {
    return entregaAssembler.toCollectionModel(entregaRepository.findAll());
  }

  @GetMapping("/entregas/{entregaId}")
  public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
    return entregaRepository.findById(entregaId)
            .map(entrega -> {
              EntregaModel entregaModel = entregaAssembler.toModel(entrega);

              return ResponseEntity.ok(entregaModel);
            })
            .orElse(ResponseEntity.notFound().build());
  }
}
