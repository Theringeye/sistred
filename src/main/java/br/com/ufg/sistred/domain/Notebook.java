package br.com.ufg.sistred.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Notebook implements Serializable {

	private static final long serialVersionUID = 1401995331656151584L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String processador;
	private String memoria;
	private String tipo_armazenamento;
	private String tamanho_armazenamento;
	private String modelo;
	private String fabricante;
	private String sistema_operacional;
	private String versao_sistema_operacional;
	private String licenca_so;
	private String patrimonio;

	@ManyToMany(mappedBy = "listaNotebook")
	private List<Movimentacao> listaMovimentacao = new ArrayList<>();

	@OneToMany(mappedBy = "notebook", fetch = FetchType.LAZY)
	private List<HistoricoAtivo> listaHistoricoAtivo = new ArrayList<>();

	public Notebook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getTipo_armazenamento() {
		return tipo_armazenamento;
	}

	public void setTipo_armazenamento(String tipo_armazenamento) {
		this.tipo_armazenamento = tipo_armazenamento;
	}

	public String getTamanho_armazenamento() {
		return tamanho_armazenamento;
	}

	public void setTamanho_armazenamento(String tamanho_armazenamento) {
		this.tamanho_armazenamento = tamanho_armazenamento;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getSistema_operacional() {
		return sistema_operacional;
	}

	public void setSistema_operacional(String sistema_operacional) {
		this.sistema_operacional = sistema_operacional;
	}

	public String getVersao_sistema_operacional() {
		return versao_sistema_operacional;
	}

	public void setVersao_sistema_operacional(String versao_sistema_operacional) {
		this.versao_sistema_operacional = versao_sistema_operacional;
	}

	public String getLicenca_so() {
		return licenca_so;
	}

	public void setLicenca_so(String licenca_so) {
		this.licenca_so = licenca_so;
	}

	public String getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public List<Movimentacao> getListaMovimentacao() {
		return listaMovimentacao;
	}

	public void setListaMovimentacao(List<Movimentacao> listaMovimentacao) {
		this.listaMovimentacao = listaMovimentacao;
	}

	public List<HistoricoAtivo> getListaHistoricoAtivo() {
		return listaHistoricoAtivo;
	}

	public void setListaHistoricoAtivo(List<HistoricoAtivo> listaHistoricoAtivo) {
		this.listaHistoricoAtivo = listaHistoricoAtivo;
	}

}
