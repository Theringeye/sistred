package br.com.ufg.sistred.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufg.sistred.domain.Gabinete;
import br.com.ufg.sistred.domain.HistoricoAtivo;
import br.com.ufg.sistred.domain.Movimentacao;
import br.com.ufg.sistred.repositories.GabineteRepository;
import br.com.ufg.sistred.repositories.HistoricoAtivoRepository;
import br.com.ufg.sistred.repositories.MovimentacaoRepository;

@Service
public class DBService {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	@Autowired
	private GabineteRepository gabineteRepository;
	
	@Autowired
	private HistoricoAtivoRepository historicoAtivoRepository;

	public void instanciaBancoDeDados() {

		

		Gabinete gabinete = new Gabinete(null, "Novo", "I5", "8GB", "Windows", "1TB", "LAÇKLA-ÇALSKD-ÇLSKD","444444",
				null, null);

		
		
		//movimentacao.getGabinetes().addAll(Arrays.asList(gabinete));

		gabineteRepository.saveAll(Arrays.asList(gabinete));
		
		
		Movimentacao movimentacao = new Movimentacao(null, "recolhimento", "DLOG", new Timestamp(0), gabinete,null);
		
		movimentacaoRepository.saveAll(Arrays.asList(movimentacao));
		
		Movimentacao movimentacao2 = new Movimentacao(null, "distribuicao", "DLOG", new Timestamp(0), gabinete,null);
		
		movimentacaoRepository.saveAll(Arrays.asList(movimentacao2));
		

		HistoricoAtivo historicoGabinete1 = new HistoricoAtivo(null, "funcionando", gabinete, null);
		
		HistoricoAtivo historicoGabinete2 = new HistoricoAtivo(null, "apresentou desfeito", gabinete, null);
		
		
		historicoAtivoRepository.save(historicoGabinete1);
		
		historicoAtivoRepository.save(historicoGabinete2);
		
	}

}
