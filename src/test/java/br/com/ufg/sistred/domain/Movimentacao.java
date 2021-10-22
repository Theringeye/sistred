package br.com.ufg.sistred.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
	
	private Timestamp data;
	
	@OneToMany(mappedBy = "movimentacao")
	private List<Gabinete> gabinetes = new ArrayList<>();
	
	@OneToMany(mappedBy = "movimentacao")
	private List<Mouse> mouses = new ArrayList<>();

	public Movimentacao() {
		super();
		// TODO Auto-generated constructor stub
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

}
