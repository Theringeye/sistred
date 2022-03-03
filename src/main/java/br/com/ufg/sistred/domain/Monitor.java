package br.com.ufg.sistred.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Monitor extends Common implements Serializable {

	private static final long serialVersionUID = -652511097168000478L;

	private String tamanho;

	@JsonManagedReference
	@ManyToMany(mappedBy = "listaMonitor")
	private List<Movimentacao> listaMovimentacao = new ArrayList<>();

	@OneToMany(mappedBy = "monitor", fetch = FetchType.LAZY)
	private List<HistoricoAtivo> listaHistoricoAtivo = new ArrayList<>();

	public Monitor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Monitor(String tamanho, List<Movimentacao> listaMovimentacao, List<HistoricoAtivo> listaHistoricoAtivo) {
		super();
		this.tamanho = tamanho;
		this.listaMovimentacao = listaMovimentacao;
		this.listaHistoricoAtivo = listaHistoricoAtivo;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
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
