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
public class DispositivoPortatil extends Common implements Serializable {

	private static final long serialVersionUID = -8937943230180084551L;

	private String tipo;

	@JsonManagedReference
	@ManyToMany(mappedBy = "listaDispositivoPortatil")
	private List<Movimentacao> listaMovimentacao = new ArrayList<>();

	@OneToMany(mappedBy = "dispositivoPortatil", fetch = FetchType.LAZY)
	private List<HistoricoAtivo> listaHistoricoAtivo = new ArrayList<>();

	public DispositivoPortatil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DispositivoPortatil(String tipo, List<Movimentacao> listaMovimentacao,
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
