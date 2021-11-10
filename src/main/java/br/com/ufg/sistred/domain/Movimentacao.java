package br.com.ufg.sistred.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Movimentacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String tipo;

	private String origem;

	private String destino;

	private Timestamp data;

	private String observacao;

	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "responsavelDepartamentoOrgao_id")
	private ResponsavelDepartamentoOrgao responsavelDepartamentoOrgao;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Movimentacao_Gabinete", joinColumns = @JoinColumn(name = "movimentacao_id"), inverseJoinColumns = @JoinColumn(name = "gabinete_id"))
	private List<Gabinete> listaGabinete = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Movimentacao_Mouse", joinColumns = @JoinColumn(name = "movimentacao_id"), inverseJoinColumns = @JoinColumn(name = "mouse_id"))
	private List<Mouse> listaMouse = new ArrayList<>();

	public Movimentacao() {
		super();
	}

	public Movimentacao(Integer id, String tipo, String origem, String destino, Timestamp data, String observacao,
			ResponsavelDepartamentoOrgao responsavelDepartamentoOrgao, List<Gabinete> listaGabinete,
			List<Mouse> listaMouse) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.origem = origem;
		this.destino = destino;
		this.data = data;
		this.observacao = observacao;
		this.responsavelDepartamentoOrgao = responsavelDepartamentoOrgao;
		this.listaGabinete = listaGabinete;
		this.listaMouse = listaMouse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public ResponsavelDepartamentoOrgao getResponsavelDepartamentoOrgao() {
		return responsavelDepartamentoOrgao;
	}

	public void setResponsavelDepartamentoOrgao(ResponsavelDepartamentoOrgao responsavelDepartamentoOrgao) {
		this.responsavelDepartamentoOrgao = responsavelDepartamentoOrgao;
	}

	public List<Gabinete> getListaGabinete() {
		return listaGabinete;
	}

	public void setListaGabinete(List<Gabinete> listaGabinete) {
		this.listaGabinete = listaGabinete;
	}

	public List<Mouse> getListaMouse() {
		return listaMouse;
	}

	public void setListaMouse(List<Mouse> listaMouse) {
		this.listaMouse = listaMouse;
	}

	public ResponsavelDepartamentoOrgao getResponsavelDepartamento() {
		return responsavelDepartamentoOrgao;
	}

	public void setResponsavelDepartamento(ResponsavelDepartamentoOrgao responsavelDepartamentoOrgao) {
		this.responsavelDepartamentoOrgao = responsavelDepartamentoOrgao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		Movimentacao other = (Movimentacao) obj;
		return Objects.equals(id, other.id);
	}

}