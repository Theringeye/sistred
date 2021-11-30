package br.com.ufg.sistred.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Notebook extends Common implements Serializable {

	private static final long serialVersionUID = 1401995331656151584L;

	private String processador;
	private String memoria;
	private String tipo_armazenamento;
	private String tamanho_armazenamento;
	private String sistema_operacional;
	private String versao_sistema_operacional;
	private String licenca_so;

	@ManyToMany(mappedBy = "listaNotebook")
	private List<Movimentacao> listaMovimentacao = new ArrayList<>();

	@OneToMany(mappedBy = "notebook", fetch = FetchType.LAZY)
	private List<HistoricoAtivo> listaHistoricoAtivo = new ArrayList<>();

	public Notebook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notebook(String processador, String memoria, String tipo_armazenamento, String tamanho_armazenamento,
			String sistema_operacional, String versao_sistema_operacional, String licenca_so,
			List<Movimentacao> listaMovimentacao, List<HistoricoAtivo> listaHistoricoAtivo) {
		super();
		this.processador = processador;
		this.memoria = memoria;
		this.tipo_armazenamento = tipo_armazenamento;
		this.tamanho_armazenamento = tamanho_armazenamento;
		this.sistema_operacional = sistema_operacional;
		this.versao_sistema_operacional = versao_sistema_operacional;
		this.licenca_so = licenca_so;
		this.listaMovimentacao = listaMovimentacao;
		this.listaHistoricoAtivo = listaHistoricoAtivo;
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
