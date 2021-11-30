package br.com.ufg.sistred.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Teclado extends Common implements Serializable {

	private static final long serialVersionUID = -7919010957833111404L;

	private String padrao;

	@ManyToMany(mappedBy = "listaTeclado")
	private List<Movimentacao> listaMovimentacao = new ArrayList<>();

	@OneToMany(mappedBy = "teclado", fetch = FetchType.LAZY)
	private List<HistoricoAtivo> listaHistoricoAtivo = new ArrayList<>();

	public Teclado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teclado(String padrao, List<Movimentacao> listaMovimentacao, List<HistoricoAtivo> listaHistoricoAtivo) {
		super();
		this.padrao = padrao;
		this.listaMovimentacao = listaMovimentacao;
		this.listaHistoricoAtivo = listaHistoricoAtivo;
	}

	public String getPadrao() {
		return padrao;
	}

	public void setPadrao(String padrao) {
		this.padrao = padrao;
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
