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

import br.com.ufg.sistred.dto.TecladoDTO;
import br.com.ufg.sistred.services.TecladoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/teclado")
public class TecladoResource {

	@Autowired
	private TecladoService tecladoService;
	
	@PostMapping
	public ResponseEntity<TecladoDTO> salvar(@RequestBody TecladoDTO tecladoDTO) {

		tecladoDTO = tecladoService.salvar(tecladoDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(tecladoDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}


	@GetMapping(value = "/{id}")
	public ResponseEntity<TecladoDTO> findById(@PathVariable Integer id) {

		return ResponseEntity.ok().body(tecladoService.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<TecladoDTO>> findAll() {

		List<TecladoDTO> listaTecladoDTO = tecladoService.findAll();

		return ResponseEntity.ok().body(listaTecladoDTO);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		tecladoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
