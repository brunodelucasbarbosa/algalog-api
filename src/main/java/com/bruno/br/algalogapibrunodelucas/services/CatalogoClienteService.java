package com.bruno.br.algalogapibrunodelucas.services;


import com.bruno.br.algalogapibrunodelucas.exceptionhandler.NegocioException;
import com.bruno.br.algalogapibrunodelucas.model.Cliente;
import com.bruno.br.algalogapibrunodelucas.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CatalogoClienteService {

  private ClienteRepository clienteRepository;


  @Transactional
  public Cliente salvar(Cliente cliente) {
    boolean emailExistente = clienteRepository.findByEmail(cliente.getEmail())
        .stream().anyMatch(clienteExistente ->
          !clienteExistente.equals(cliente)
        );

    if(emailExistente) {
      throw new NegocioException("E-mail já cadastrado.");
    }

    return clienteRepository.save(cliente);
  }

  @Transactional
  public void excluir(Long clienteId) {
    clienteRepository.deleteById(clienteId);
  }
}
