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

import br.com.ufg.sistred.dto.UnidadeOrgaoDTO;
import br.com.ufg.sistred.services.UnidadeOrgaoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/unidadeorgao")
public class UnidadeOrgaoResource {

	@Autowired
	private UnidadeOrgaoService unidadeOrgaoService;
	
	@PostMapping
	public ResponseEntity<UnidadeOrgaoDTO> salvar(@RequestBody UnidadeOrgaoDTO unidadeOrgaoDTO) {

		unidadeOrgaoDTO = unidadeOrgaoService.salvar(unidadeOrgaoDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(unidadeOrgaoDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}


	@GetMapping(value = "/{id}")
	public ResponseEntity<UnidadeOrgaoDTO> findById(@PathVariable Integer id) {

		return ResponseEntity.ok().body(unidadeOrgaoService.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<UnidadeOrgaoDTO>> findAll() {

		List<UnidadeOrgaoDTO> listaUnidadeOrgaoDTO = unidadeOrgaoService.findAll();

		return ResponseEntity.ok().body(listaUnidadeOrgaoDTO);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		unidadeOrgaoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
