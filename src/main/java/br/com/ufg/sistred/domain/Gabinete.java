package br.com.ufg.sistred.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Gabinete implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String estado;
	private String processador;
	private String memoria;
	private String sistema_operacional;
	private String disco_rigido;
	private String licenca;

	@JsonIgnore
	@ManyToOne(optional = true)
	@JoinColumn(name = "movimentacao_id")
	private Movimentacao movimentacao;

	public Gabinete() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gabinete(Integer id, String estado, String processador, String memoria, String sistema_operacional,
			String disco_rigido, String licenca, Movimentacao movimentacao) {
		super();
		this.id = id;
		this.estado = estado;
		this.processador = processador;
		this.memoria = memoria;
		this.sistema_operacional = sistema_operacional;
		this.disco_rigido = disco_rigido;
		this.licenca = licenca;
		this.movimentacao = movimentacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getSistema_operacional() {
		return sistema_operacional;
	}

	public void setSistema_operacional(String sistema_operacional) {
		this.sistema_operacional = sistema_operacional;
	}

	public String getDisco_rigido() {
		return disco_rigido;
	}

	public void setDisco_rigido(String disco_rigido) {
		this.disco_rigido = disco_rigido;
	}

	public String getLicenca() {
		return licenca;
	}

	public void setLicenca(String licenca) {
		this.licenca = licenca;
	}

	public Movimentacao getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gabinete other = (Gabinete) obj;
		return Objects.equals(id, other.id);
	}

}
