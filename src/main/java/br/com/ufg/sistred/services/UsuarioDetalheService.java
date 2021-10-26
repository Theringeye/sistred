package br.com.ufg.sistred.services;

import br.com.ufg.sistred.domain.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.ufg.sistred.repositories.UsuarioRepository;
import br.com.ufg.sistred.security.UsuarioDetalhe;

/**
 * 
 * @author Ericson de Castro
 * @Descricao: Esse é o serviço padrão do SpringSecurity utilizado para consulta
 *             e validação da senha do usuário.
 */
@Component
public class UsuarioDetalheService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByLogin(username);
		if (usuario.isEmpty()) {
			throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
		}

		return new UsuarioDetalhe(usuario);
	}

}
