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

import br.com.ufg.sistred.dto.MonitorDTO;
import br.com.ufg.sistred.services.MonitorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/monitor")
public class MonitorResource {

	@Autowired
	private MonitorService monitorService;
	
	@PostMapping
	public ResponseEntity<MonitorDTO> salvar(@RequestBody MonitorDTO MonitorDTO) {

		MonitorDTO = monitorService.salvar(MonitorDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(MonitorDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}


	@GetMapping(value = "/{id}")
	public ResponseEntity<MonitorDTO> findById(@PathVariable Integer id) {

		return ResponseEntity.ok().body(monitorService.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<MonitorDTO>> findAll() {

		List<MonitorDTO> listaMonitorDTO = monitorService.findAll();

		return ResponseEntity.ok().body(listaMonitorDTO);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		monitorService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
