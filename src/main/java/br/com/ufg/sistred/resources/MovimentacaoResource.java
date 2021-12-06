package br.com.ufg.sistred.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ufg.sistred.dto.MovimentacaoDTO;
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
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoResource {

	@Autowired
	private MovimentacaoService movimentacaoService;


	@PostMapping
	public ResponseEntity<MovimentacaoDTO> salvar(@RequestBody MovimentacaoDTO movimentacaoDTO) {

		movimentacaoDTO = movimentacaoService.salvar(movimentacaoDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(movimentacaoDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}


	@GetMapping(value = "/{id}")
	public ResponseEntity<MovimentacaoDTO> findById(@PathVariable Integer id) {

		return ResponseEntity.ok().body(movimentacaoService.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<MovimentacaoDTO>> findAll(@PathVariable Integer id) {

		List<MovimentacaoDTO> listaMovimentacaoDTO = movimentacaoService.findAll();

		return ResponseEntity.ok().body(listaMovimentacaoDTO);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		movimentacaoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
