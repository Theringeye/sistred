package br.com.ufg.sistred.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HistoricoAtivo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String situacao;

	@ManyToOne(optional = true)
	@JoinColumn(name = "gabinete_id")
	private Gabinete gabinete;

	@ManyToOne(optional = true)
	@JoinColumn(name = "mouse_id")
	private Mouse mouse;

	public HistoricoAtivo(Integer id, String situacao, Gabinete gabinete, Mouse mouse) {
		super();
		this.id = id;
		this.situacao = situacao;
		this.gabinete = gabinete;
		this.mouse = mouse;
	}

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

	public Gabinete getGabinete() {
		return gabinete;
	}

	public void setGabinete(Gabinete gabinete) {
		this.gabinete = gabinete;
	}

	public Mouse getMouse() {
		return mouse;
	}

	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
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
		HistoricoAtivo other = (HistoricoAtivo) obj;
		return Objects.equals(id, other.id);
	}

}
