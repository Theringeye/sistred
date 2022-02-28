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

import br.com.ufg.sistred.dto.TecnicoAdministrativoDTO;
import br.com.ufg.sistred.services.TecnicoAdministrativoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tecnicoadministrativo")
public class TecnicoAdministrativoResource {

	@Autowired
	private TecnicoAdministrativoService ta;
	
	@PostMapping
	public ResponseEntity<TecnicoAdministrativoDTO> salvar(@RequestBody TecnicoAdministrativoDTO unidadeOrgaoDTO) {

		unidadeOrgaoDTO = ta.salvar(unidadeOrgaoDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(unidadeOrgaoDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}


	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoAdministrativoDTO> findById(@PathVariable Integer id) {

		return ResponseEntity.ok().body(ta.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<TecnicoAdministrativoDTO>> findAll() {

		List<TecnicoAdministrativoDTO> listaTecnicoAdministrativoDTO = ta.findAll();

		return ResponseEntity.ok().body(listaTecnicoAdministrativoDTO);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		ta.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
