package br.com.ufg.sistred.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufg.sistred.domain.Movimentacao;
import br.com.ufg.sistred.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoService {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	/**
	 * 
	 * O objeto Optional é utilizado para que caso não haja retorno de objeto ele
	 * retorna vazio.
	 */
	public Movimentacao findById(Integer id) {

		Optional<Movimentacao> obj = movimentacaoRepository.findById(id);
		return obj.orElse(null);

	}

}
