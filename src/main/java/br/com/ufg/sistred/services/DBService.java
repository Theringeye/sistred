package br.com.ufg.sistred.services;

import java.sql.Timestamp;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufg.sistred.domain.Gabinete;
import br.com.ufg.sistred.domain.Movimentacao;
import br.com.ufg.sistred.repositories.GabineteRepository;
import br.com.ufg.sistred.repositories.MovimentacaoRepository;

@Service
public class DBService {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	@Autowired
	private GabineteRepository gabineteRepository;

	public void instanciaBancoDeDados() {

		Movimentacao movimentacao = new Movimentacao(null, "recolhimento", "DLOG", new Timestamp(0));

		Gabinete gabinete = new Gabinete(null, "Novo", "I5", "8GB", "Windows", "1TB", "LAÇKLA-ÇALSKD-ÇLSKD",
				movimentacao);

		movimentacao.getGabinetes().addAll(Arrays.asList(gabinete));

		movimentacaoRepository.saveAll(Arrays.asList(movimentacao));
		gabineteRepository.saveAll(Arrays.asList(gabinete));
	}

}
