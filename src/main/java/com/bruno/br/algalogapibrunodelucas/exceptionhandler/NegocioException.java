package com.bruno.br.algalogapibrunodelucas.exceptionhandler;

public class NegocioException extends RuntimeException {

  public NegocioException(String mensagem) {
    super(mensagem);
  }
}
