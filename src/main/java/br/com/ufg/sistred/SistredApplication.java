package br.com.ufg.sistred;

import java.sql.Timestamp;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ufg.sistred.domain.Gabinete;
import br.com.ufg.sistred.domain.Movimentacao;
import br.com.ufg.sistred.repositories.GabineteRepository;
import br.com.ufg.sistred.repositories.MovimentacaoRepository;

@SpringBootApplication
public class SistredApplication implements CommandLineRunner {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	@Autowired
	private GabineteRepository gabineteRepository;

	public static void main(String[] args) {
		SpringApplication.run(SistredApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Movimentacao movimentacao = new Movimentacao(null, "recolhimento", "DLOG", new Timestamp(0));

		Gabinete gabinete = new Gabinete(null, "Novo", "I5", "4GB", "Windows", "1TB", "LAÇKLA-ÇALSKD-ÇLSKD",
				movimentacao);

		movimentacao.getGabinetes().addAll(Arrays.asList(gabinete));

		movimentacaoRepository.saveAll(Arrays.asList(movimentacao));
		gabineteRepository.saveAll(Arrays.asList(gabinete));

	}
}
