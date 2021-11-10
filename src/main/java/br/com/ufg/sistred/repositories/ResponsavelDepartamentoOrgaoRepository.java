package br.com.ufg.sistred.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufg.sistred.domain.ResponsavelDepartamentoOrgao;

@Repository
public interface ResponsavelDepartamentoOrgaoRepository extends JpaRepository<ResponsavelDepartamentoOrgao, Integer> {

}
