package br.com.ufg.sistred.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

public class HistoricoAtivoDTO {

	private Integer id;

	private String situacao;

	private Timestamp data;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

}
