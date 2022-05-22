package com.bruno.br.algalogapibrunodelucas.controller;


import com.bruno.br.algalogapibrunodelucas.dto.DestinatarioModel;
import com.bruno.br.algalogapibrunodelucas.dto.EntregaModel;
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
  private ModelMapper modelMapper;

  @PostMapping("/entregas")
  @ResponseStatus(HttpStatus.CREATED)
  public Entrega criar(@Valid @RequestBody Entrega entrega) {
    return solicitacaoEntregaService.solicitar(entrega);
  }

  @GetMapping("/entregas")
  public List<Entrega> listar() {
    return entregaRepository.findAll();
  }

  @GetMapping("/entregas/{entregaId}")
  public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
    return entregaRepository.findById(entregaId)
            .map(entrega -> {
//              EntregaModel entregaModel = new EntregaModel();
//              entregaModel.setId(entrega.getId());
//              entregaModel.setNomeCliente(entrega.getCliente().getNome());
//              entregaModel.setDestinatario(new DestinatarioModel());
//              entregaModel.getDestinatario().setNome(entrega.getDestinatario().getNome());
//              entregaModel.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
//              entregaModel.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
//              entregaModel.getDestinatario().setComplemento(entrega.getDestinatario().getNome());
//              entregaModel.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
//              entregaModel.setTaxa(entrega.getTaxa());
//              entregaModel.setStatus(entrega.getStatus());
//              entregaModel.setDataPedido(entrega.getDataPedido());
//              entregaModel.setDataFinalizacao(entrega.getDataFinalizacao());

              EntregaModel entregaModel = modelMapper.map(entrega, EntregaModel.class);

              return ResponseEntity.ok(entregaModel);
            })
            .orElse(ResponseEntity.notFound().build());
  }
}
