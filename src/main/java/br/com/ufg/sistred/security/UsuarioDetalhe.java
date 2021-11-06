package br.com.ufg.sistred.security;

import br.com.ufg.sistred.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * @author Ericson de Castro
 * @Descricao: Classe responsavel por repassar ao UserDetail, interface do
 *             SpringSecurity, os dados do modelo: usuário e senha.
 */
public class UsuarioDetalhe implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Optional<Usuario> usuario;

	public UsuarioDetalhe(Optional<Usuario> usuario) {
		this.usuario = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// Array utilizado para adicionar as permissões do usuário.
		return new ArrayList<>();

	}

	@Override
	public String getPassword() {

		return usuario.orElse(new Usuario()).getPassword();

	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usuario.orElse(new Usuario()).getLogin();

	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Verifica se o usuário está ativo. Por padrão será deixado como true, porém
	 * poderá ser tratado de acordo com a necessidade.
	 */
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
