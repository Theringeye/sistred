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
import br.com.ufg.sistred.dto.GabineteDTO;
import br.com.ufg.sistred.services.GabineteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/gabinete")
public class GabineteResource {
	
	@Autowired
	private GabineteService gabineteService;
	
	@PostMapping
	public ResponseEntity<GabineteDTO> salvar(@RequestBody GabineteDTO gabineteDTO) {

		gabineteDTO = gabineteService.salvar(gabineteDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(gabineteDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}


	@GetMapping(value = "/{id}")
	public ResponseEntity<GabineteDTO> findById(@PathVariable Integer id) {

		return ResponseEntity.ok().body(gabineteService.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<GabineteDTO>> findAll() {

		List<GabineteDTO> listaGabineteDTO = gabineteService.findAll();

		return ResponseEntity.ok().body(listaGabineteDTO);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		gabineteService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	

}