package br.com.ufg.sistred.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufg.sistred.domain.HistoricoAtivo;

@Repository
public interface HistoricoAtivoRepository extends JpaRepository<HistoricoAtivo, Integer> {

}
