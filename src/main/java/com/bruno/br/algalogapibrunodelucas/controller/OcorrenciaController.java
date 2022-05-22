package com.bruno.br.algalogapibrunodelucas.controller;

import com.bruno.br.algalogapibrunodelucas.dto.OcorrenciaModel;
import com.bruno.br.algalogapibrunodelucas.dto.input.OcorrenciaInput;
import com.bruno.br.algalogapibrunodelucas.mapper.OcorrenciaAssembler;
import com.bruno.br.algalogapibrunodelucas.model.Entrega;
import com.bruno.br.algalogapibrunodelucas.model.Ocorrencia;
import com.bruno.br.algalogapibrunodelucas.services.BuscaEntregaService;
import com.bruno.br.algalogapibrunodelucas.services.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

  private BuscaEntregaService buscaEntregaService;
  private RegistroOcorrenciaService registroOcorrenciaService;
  private OcorrenciaAssembler ocorrenciaAssembler;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public OcorrenciaModel registrar(@PathVariable Long entregaId,
                                   @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {

    Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
                                      .registrar(entregaId, ocorrenciaInput.getDescricao());

    return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
  }

  @GetMapping
  public List<OcorrenciaModel> listar(@PathVariable Long entregaId) {
    Entrega entrega = buscaEntregaService.buscar(entregaId);

    return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
  }
}
