package com.bruno.br.algalogapibrunodelucas.controller;

import com.bruno.br.algalogapibrunodelucas.exceptionhandler.NegocioException;
import com.bruno.br.algalogapibrunodelucas.model.Cliente;
import com.bruno.br.algalogapibrunodelucas.repository.ClienteRepository;
import com.bruno.br.algalogapibrunodelucas.services.CatalogoClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class ClienteController {

    private ClienteRepository clienteRepository;
    private CatalogoClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping("/clientes/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
//        return clienteRepository.findById(clienteId)
//            .map(cliente -> ResponseEntity.ok(cliente))
//            .orElse(ResponseEntity.notFound().build());

        Optional<Cliente> cliente = clienteRepository.findById(clienteId);

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    @PutMapping("/clientes/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteId,
                                             @RequestBody Cliente cliente) {

        if(!clienteRepository.existsById(clienteId)) {
            throw new NegocioException("Cliente não encontrado!");
        }

        cliente.setId(clienteId);
        cliente = clienteService.salvar(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/clientes/{clienteId}")
    public ResponseEntity<Void> deletar(@PathVariable Long clienteId) {
        if(!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }

        clienteService.excluir(clienteId);

        return ResponseEntity.noContent().build();
    }
}
