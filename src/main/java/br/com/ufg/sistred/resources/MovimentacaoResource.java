package br.com.ufg.sistred.resources;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufg.sistred.domain.JwtRequest;
import br.com.ufg.sistred.domain.Movimentacao;
import br.com.ufg.sistred.domain.Usuario;
import br.com.ufg.sistred.dto.MovimentacaoDTO;
import br.com.ufg.sistred.dto.TesteDTO;
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
@RequestMapping("/movimentacao")
public class MovimentacaoResource {

	@Autowired
	private MovimentacaoService movimentacaoService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/salvar")
	public JwtRequest salvar( @RequestBody JwtRequest movimentacaoDTO) {
				
		movimentacaoDTO.getUsername();
		
		return movimentacaoDTO;
		//return ResponseEntity.ok(movimentacaoService.save(movimentacaoDTO));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovimentacaoDTO> findById(@PathVariable Integer id) {

		//Movimentacao movimentacao = movimentacaoService.findById(id);

		return ResponseEntity.ok().body(movimentacaoService.findById(id));
	}
	
	

}
