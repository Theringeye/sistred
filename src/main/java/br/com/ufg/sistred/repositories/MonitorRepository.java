package br.com.ufg.sistred.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.ufg.sistred.domain.Monitor;

public interface MonitorRepository extends JpaRepository<Monitor, Integer> {

}
