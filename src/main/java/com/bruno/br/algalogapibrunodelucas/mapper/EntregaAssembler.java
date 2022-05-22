package com.bruno.br.algalogapibrunodelucas.mapper;

import com.bruno.br.algalogapibrunodelucas.dto.EntregaModel;
import com.bruno.br.algalogapibrunodelucas.dto.input.EntregaInputModel;
import com.bruno.br.algalogapibrunodelucas.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EntregaAssembler {

  private ModelMapper modelMapper;

  public EntregaModel toModel(Entrega entrega) {
    return modelMapper.map(entrega, EntregaModel.class);
  }

  public List<EntregaModel> toCollectionModel(List<Entrega> entregas) {
    return entregas.stream()
            .map(entrega -> toModel(entrega))
            .collect(Collectors.toList());
  }

  public Entrega toEntity(EntregaInputModel entregaInputModel) {
    return modelMapper.map(entregaInputModel, Entrega.class);
  }

}
