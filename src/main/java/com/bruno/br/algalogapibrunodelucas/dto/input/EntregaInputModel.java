package com.bruno.br.algalogapibrunodelucas.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EntregaInputModel {

  @Valid @NotNull
  private ClienteIdInput cliente;

  @Valid @NotNull
  private DestinatarioInput destinatario;

  private BigDecimal taxa;


}
