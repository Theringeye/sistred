package br.com.ufg.sistred.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ufg.sistred.domain.Usuario;

/**
 * 
 * @author Ericson de Castro
 * @Descricao: Classe responsável por autenticar o usuário e gerar o token JTW
 */
public class JWTAutenticarFiltro extends UsernamePasswordAuthenticationFilter {

	// tempo em milisegundos
	public static final int TOKEN_EXPIRA = 600_000;
	// Esse GUID deve ser adicionada em arquivo de configuração
	// public static final String TOKEN_SENHA =
	// "463408a1-54c9-4307-bb1c-6cced559f5a7";

	private final AuthenticationManager authenticationManager;

	public JWTAutenticarFiltro(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {

			// Pega os valores digitados nos campos login e senha, em JSON, e converte para
			// o objeto Usuario
			Usuario usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);

			// realiza a autenticação do usuário
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getLogin(),
					usuario.getPassword(), new ArrayList<>()));

		} catch (IOException e) {
			throw new RuntimeException("Falha ao autenticar usuario", e);
		}

	}

	/**
	 * Esse método é executado caso a autenticação tenha sido efetuada com sucesso.
	 */
	/*
	 * @Override protected void successfulAuthentication(HttpServletRequest request,
	 * HttpServletResponse response, FilterChain chain, Authentication authResult)
	 * throws IOException, ServletException {
	 * 
	 * // UsuarioDetalhe usuarioData = (UsuarioDetalhe) authResult.getPrincipal();
	 * 
	 * // Aqui acontece a geração do token String token =
	 * JWT.create().withSubject(usuarioData.getUsername()) .withExpiresAt(new
	 * Date(System.currentTimeMillis() + TOKEN_EXPIRA)) // essa parte é a parte em
	 * que o token é assinado. .sign(Algorithm.HMAC512(TOKEN_SENHA));
	 * 
	 * // Aqui o token é enviado ao usuário. Registrado no corpo da página
	 * response.getWriter().write(token); response.getWriter().flush(); }
	 */

}
