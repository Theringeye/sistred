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

import br.com.ufg.sistred.dto.CaboDTO;
import br.com.ufg.sistred.services.CaboService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cabo")
public class CaboResource {

	@Autowired
	private CaboService caboService;


	@PostMapping
	public ResponseEntity<CaboDTO> salvar(@RequestBody CaboDTO caboDTO) {

		caboDTO = caboService.salvar(caboDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(caboDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}


	@GetMapping(value = "/{id}")
	public ResponseEntity<CaboDTO> findById(@PathVariable Integer id) {

		return ResponseEntity.ok().body(caboService.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<CaboDTO>> findAll() {

		List<CaboDTO> listaCaboDTO = caboService.findAll();

		return ResponseEntity.ok().body(listaCaboDTO);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		caboService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
