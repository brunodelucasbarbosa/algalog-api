package com.bruno.br.algalogapibrunodelucas.model;

import com.bruno.br.algalogapibrunodelucas.validation.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;


@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Entrega {

  @EqualsAndHashCode.Include
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "cliente_id")
  @ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
  @NotNull
  @Valid
  private Cliente cliente;

  @Embedded
  @Valid
  @NotNull
  private Destinatario destinatario;

  @NotNull
  private BigDecimal taxa;

  @Enumerated(EnumType.STRING)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private StatusEntrega status;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private OffsetDateTime dataPedido;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private OffsetDateTime dataFinalizacao;


}
