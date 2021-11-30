package br.com.ufg.sistred.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufg.sistred.domain.TecnicoAdministrativo;

@Repository
public interface TecnicoAdministrativoRepository extends JpaRepository<TecnicoAdministrativo, Integer> {

}
