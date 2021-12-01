package br.com.ufg.sistred.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private String jwttoken;

	public JwtResponse(String jwttoken) {
		super();
		this.jwttoken = jwttoken;
	}

}