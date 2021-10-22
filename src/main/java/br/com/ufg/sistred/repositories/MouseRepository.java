package br.com.ufg.sistred.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufg.sistred.domain.Mouse;
import br.com.ufg.sistred.domain.Movimentacao;

@Repository
public interface MouseRepository extends JpaRepository<Mouse, Integer> {

}
