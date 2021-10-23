package br.com.ufg.sistred.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.ufg.sistred.services.DBService;

@Configuration
@Profile("desenv")
public class TestConfig {

	@Autowired
	public DBService dbService;

	/**
	 * Sempre que anotar com @Bean, o método irá ser executado.
	 */
	@Bean
	public void instanciaBaseDeDados() {

		this.dbService.instanciaBancoDeDados();

	}

}
