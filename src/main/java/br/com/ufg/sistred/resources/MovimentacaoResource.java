package br.com.ufg.sistred.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufg.sistred.domain.Movimentacao;
import br.com.ufg.sistred.services.MovimentacaoService;

/**
 * 
 * @author Ericson de Castro
 * 
 *         Descrição: Classe responsável por controlar as requisições rest de
 *         Movimentações
 * 
 * 
 */
@RestController
@RequestMapping(value = "/movimentacoes")
public class MovimentacaoResource {

	@Autowired
	private MovimentacaoService movimentacaoService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Movimentacao> findById(@PathVariable Integer id) {

		Movimentacao movimentacao = movimentacaoService.findById(id);

		return ResponseEntity.ok().body(movimentacao);
	}

}
