package br.com.ufg.sistred.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.ufg.sistred.services.UsuarioDetalheService;

/**
 * 
 * @author Ericson de Castro
 * @Descricao: Classe responsável por validar a autenticação
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	public static final String HEADER_ATRIBUTO = "Authorization";
	public static final String ATRIBUTO_PREFIXO = "Bearer ";

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UsuarioDetalheService jwtUserDetailsService;

	@Value("${jwt.secret}")
	private String secret;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String atributo = request.getHeader(HEADER_ATRIBUTO);

		if (atributo == null) {
			chain.doFilter(request, response);
			return;
		}

		if (!atributo.startsWith(ATRIBUTO_PREFIXO)) {
			chain.doFilter(request, response);
			return;
		}

		String token = atributo.replace(ATRIBUTO_PREFIXO, "");
		UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(token);

		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		chain.doFilter(request, response);

		/*
		 * final String requestTokenHeader = request.getHeader("Authorization");
		 * 
		 * String username = null; String jwtToken = null;
		 * 
		 * // JWT Token está no form "Bearer token". Remova a palavra Bearer e pegue //
		 * somente o Token if (requestTokenHeader != null &&
		 * requestTokenHeader.startsWith("Bearer ")) { jwtToken =
		 * requestTokenHeader.substring(7); try { username =
		 * jwtTokenUtil.getUsernameFromToken(jwtToken); } catch
		 * (IllegalArgumentException e) { System.out.println("Unable to get JWT Token");
		 * } catch (Exception e) { System.out.println("JWT Token has expired"); } } else
		 * { logger.warn("JWT Token does not begin with Bearer String"); }
		 * 
		 * // Tendo o token, valide o. if (username != null &&
		 * SecurityContextHolder.getContext().getAuthentication() == null) { UserDetails
		 * userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
		 * 
		 * if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
		 * UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new
		 * UsernamePasswordAuthenticationToken( userDetails, null,
		 * userDetails.getAuthorities()); usernamePasswordAuthenticationToken
		 * .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		 * 
		 * SecurityContextHolder.getContext().setAuthentication(
		 * usernamePasswordAuthenticationToken); } } chain.doFilter(request, response);
		 * }
		 */
	}

	/**
	 * 
	 * @param token
	 * @descricao: método responsável por fazer a leitura do token e garantir que o
	 *             usuário é válido.
	 */
	private UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {

		String usuario = JWT.require(Algorithm.HMAC512(secret)).build().verify(token).getSubject();

		if (usuario == null) {
			return null;
		}

		return new UsernamePasswordAuthenticationToken(usuario, null, new ArrayList<>());
	}

}
