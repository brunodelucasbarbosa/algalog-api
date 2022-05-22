package com.bruno.br.algalogapibrunodelucas.mapper;

import com.bruno.br.algalogapibrunodelucas.dto.OcorrenciaModel;
import com.bruno.br.algalogapibrunodelucas.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OcorrenciaAssembler {

  private ModelMapper modelMapper;

  public OcorrenciaModel toModel(Ocorrencia ocorrencia) {
    return modelMapper.map(ocorrencia, OcorrenciaModel.class);
  }
}
