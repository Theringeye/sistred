package br.com.ufg.sistred.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ufg.sistred.domain.Cabo;
import br.com.ufg.sistred.domain.Teclado;

public interface TecladoRepository extends JpaRepository<Teclado, Integer> {

}
