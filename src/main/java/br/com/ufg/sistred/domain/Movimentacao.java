package br.com.ufg.sistred.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Movimentacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String tipo;
	
	private String localidade;

	private Timestamp data;
	
	@OneToMany(mappedBy = "movimentacao")
	private List<Gabinete> gabinetes = new ArrayList<>();

	@OneToMany(mappedBy = "movimentacao")
	private List<Mouse> mouses = new ArrayList<>();

	public Movimentacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movimentacao(Integer id, String tipo, String localidade, Timestamp data) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.localidade = localidade;
		this.data = data;
	
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

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public List<Gabinete> getGabinetes() {
		return gabinetes;
	}

	public void setGabinetes(List<Gabinete> gabinetes) {
		this.gabinetes = gabinetes;
	}

	public List<Mouse> getMouses() {
		return mouses;
	}

	public void setMouses(List<Mouse> mouses) {
		this.mouses = mouses;
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