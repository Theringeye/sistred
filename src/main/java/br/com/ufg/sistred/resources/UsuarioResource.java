package br.com.ufg.sistred.resources;

import br.com.ufg.sistred.domain.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufg.sistred.repositories.UsuarioRepository;

/**
 * 
 * @author Ericson de Castro
 * Descricao: Classe responsável por manipular os dados de login do usuário, no banco;
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

	@Autowired
	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder encoder;

	public UsuarioResource(UsuarioRepository repository, PasswordEncoder encoder) {
		this.usuarioRepository = repository;
		this.encoder = encoder;
	}

	@GetMapping("/listarTodos")
	public ResponseEntity<List<Usuario>> listarTodos() {
		return ResponseEntity.ok(usuarioRepository.findAll());
	}

	@PostMapping("/salvar")
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
		usuario.setPassword(encoder.encode(usuario.getPassword()));
		return ResponseEntity.ok(usuarioRepository.save(usuario));
	}

	@GetMapping("/validarSenha")
	public ResponseEntity<Boolean> validarSenha(@RequestParam String login, @RequestParam String password) {

		Optional<Usuario> optUsuario = usuarioRepository.findByLogin(login);
		if (optUsuario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
		}

		Usuario usuario = optUsuario.get();
		boolean valid = encoder.matches(password, usuario.getPassword());

		HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
		return ResponseEntity.status(status).body(valid);

	}

}
