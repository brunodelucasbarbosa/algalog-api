package com.bruno.br.algalogapibrunodelucas.controller;

import com.bruno.br.algalogapibrunodelucas.dto.OcorrenciaModel;
import com.bruno.br.algalogapibrunodelucas.dto.input.OcorrenciaInput;
import com.bruno.br.algalogapibrunodelucas.mapper.OcorrenciaAssembler;
import com.bruno.br.algalogapibrunodelucas.model.Ocorrencia;
import com.bruno.br.algalogapibrunodelucas.services.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/entregas/{entregaId/ocorrencias")
public class OcorrenciaController {

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
}
