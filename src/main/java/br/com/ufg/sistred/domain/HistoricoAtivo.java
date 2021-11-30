package br.com.ufg.sistred.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HistoricoAtivo implements Serializable {

	private static final long serialVersionUID = -7073977703044155973L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String situacao;
	private Timestamp data;

	@ManyToOne(optional = true)
	@JoinColumn(name = "gabinete_id")
	private Gabinete gabinete;

	@ManyToOne(optional = true)
	@JoinColumn(name = "mouse_id")
	private Mouse mouse;

	@ManyToOne(optional = true)
	@JoinColumn(name = "cabo_id")
	private Cabo cabo;

	@ManyToOne(optional = true)
	@JoinColumn(name = "dispositivoProtecao_id")
	private DispositivoProtecao dispositivoProtecao;

	@ManyToOne(optional = true)
	@JoinColumn(name = "impressora_id")
	private Impressora impressora;

	@ManyToOne(optional = true)
	@JoinColumn(name = "monitor_id")
	private Monitor monitor;

	@ManyToOne(optional = true)
	@JoinColumn(name = "notebook_id")
	private Notebook notebook;

	@ManyToOne(optional = true)
	@JoinColumn(name = "teclado_id")
	private Teclado teclado;

	@ManyToOne(optional = true)
	@JoinColumn(name = "dispositivoPortatil_id")
	private DispositivoPortatil dispositivoPortatil;

	public HistoricoAtivo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HistoricoAtivo(Integer id, String situacao, Timestamp data, Gabinete gabinete, Mouse mouse, Cabo cabo,
			DispositivoProtecao dispositivoProtecao, Impressora impressora, Monitor monitor, Notebook notebook,
			Teclado teclado, DispositivoPortatil dispositivoPortatil) {
		super();
		this.id = id;
		this.situacao = situacao;
		this.data = data;
		this.gabinete = gabinete;
		this.mouse = mouse;
		this.cabo = cabo;
		this.dispositivoProtecao = dispositivoProtecao;
		this.impressora = impressora;
		this.monitor = monitor;
		this.notebook = notebook;
		this.teclado = teclado;
		this.dispositivoPortatil = dispositivoPortatil;
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

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
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

	public Cabo getCabo() {
		return cabo;
	}

	public void setCabo(Cabo cabo) {
		this.cabo = cabo;
	}

	public DispositivoProtecao getDispositivoProtecao() {
		return dispositivoProtecao;
	}

	public void setDispositivoProtecao(DispositivoProtecao dispositivoProtecao) {
		this.dispositivoProtecao = dispositivoProtecao;
	}

	public Impressora getImpressora() {
		return impressora;
	}

	public void setImpressora(Impressora impressora) {
		this.impressora = impressora;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public Notebook getNotebook() {
		return notebook;
	}

	public void setNotebook(Notebook notebook) {
		this.notebook = notebook;
	}

	public Teclado getTeclado() {
		return teclado;
	}

	public void setTeclado(Teclado teclado) {
		this.teclado = teclado;
	}

	public DispositivoPortatil getDispositivoPortatil() {
		return dispositivoPortatil;
	}

	public void setDispositivoPortatil(DispositivoPortatil dispositivoPortatil) {
		this.dispositivoPortatil = dispositivoPortatil;
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
