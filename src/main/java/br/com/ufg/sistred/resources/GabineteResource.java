package br.com.ufg.sistred.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufg.sistred.domain.Gabinete;
import br.com.ufg.sistred.services.GabineteService;

@RestController
@RequestMapping(value = "/gabinete")
public class GabineteResource {

	@Autowired
	private GabineteService gabineteService;

	@PostMapping("/salvar")
	public ResponseEntity<Gabinete> salvar(@RequestBody Gabinete gabinete) {

		return ResponseEntity.ok(gabineteService.save(gabinete));
	}

}
