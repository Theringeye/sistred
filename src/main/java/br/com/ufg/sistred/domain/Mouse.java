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
public class Mouse extends Common implements Serializable {

	private static final long serialVersionUID = -7110734384444306869L;

	private String codigo_identificacao;

	@JsonManagedReference
	@ManyToMany(mappedBy = "listaMouse")
	private List<Movimentacao> listaMovimentacao = new ArrayList<>();

	@OneToMany(mappedBy = "mouse", fetch = FetchType.LAZY)
	private List<HistoricoAtivo> listaHistoricoAtivo = new ArrayList<>();

	public Mouse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mouse(String codigo_identificacao, List<Movimentacao> listaMovimentacao,
			List<HistoricoAtivo> listaHistoricoAtivo) {
		super();
		this.codigo_identificacao = codigo_identificacao;
		this.listaMovimentacao = listaMovimentacao;
		this.listaHistoricoAtivo = listaHistoricoAtivo;
	}

	public String getCodigo_identificacao() {
		return codigo_identificacao;
	}

	public void setCodigo_identificacao(String codigo_identificacao) {
		this.codigo_identificacao = codigo_identificacao;
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
