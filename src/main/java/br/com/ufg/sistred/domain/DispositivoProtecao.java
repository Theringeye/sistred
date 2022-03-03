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
public class DispositivoProtecao extends Common implements Serializable {

	private static final long serialVersionUID = -5813260051435169067L;

	private String tipo;

	@JsonManagedReference
	@ManyToMany(mappedBy = "listaDispositivoProtecao")
	private List<Movimentacao> listaMovimentacao = new ArrayList<>();

	@OneToMany(mappedBy = "dispositivoProtecao", fetch = FetchType.LAZY)
	private List<HistoricoAtivo> listaHistoricoAtivo = new ArrayList<>();

	public DispositivoProtecao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DispositivoProtecao(String tipo, List<Movimentacao> listaMovimentacao,
			List<HistoricoAtivo> listaHistoricoAtivo) {
		super();
		this.tipo = tipo;
		this.listaMovimentacao = listaMovimentacao;
		this.listaHistoricoAtivo = listaHistoricoAtivo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
