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

import br.com.ufg.sistred.dto.MouseDTO;
import br.com.ufg.sistred.services.MouseService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/mouse")
public class MouseResource {

	@Autowired
	private MouseService mouseService;


	@PostMapping
	public ResponseEntity<MouseDTO> salvar(@RequestBody MouseDTO MouseDTO) {

		MouseDTO = mouseService.salvar(MouseDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(MouseDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}


	@GetMapping(value = "/{id}")
	public ResponseEntity<MouseDTO> findById(@PathVariable Integer id) {

		return ResponseEntity.ok().body(mouseService.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<MouseDTO>> findAll() {

		List<MouseDTO> listaMouseDTO = mouseService.findAll();

		return ResponseEntity.ok().body(listaMouseDTO);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		mouseService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
