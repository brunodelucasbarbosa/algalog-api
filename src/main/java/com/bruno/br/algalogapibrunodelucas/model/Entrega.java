package com.bruno.br.algalogapibrunodelucas.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Entrega {

  @EqualsAndHashCode.Include
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  @Embedded
  private Destinatario destinatario;

  private BigDecimal taxa;

  @Enumerated(EnumType.STRING)
  private StatusEntrega status;
  private LocalDateTime dataPedido;
  private LocalDateTime dataFinalizacao;
}