package com.bruno.br.algalogapibrunodelucas.repository;

import com.bruno.br.algalogapibrunodelucas.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
