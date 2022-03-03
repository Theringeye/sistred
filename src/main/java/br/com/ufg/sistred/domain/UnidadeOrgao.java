package br.com.ufg.sistred.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class UnidadeOrgao implements Serializable {

	private static final long serialVersionUID = 9060497739314920017L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nomeUnidade;
	private String siglaUnidade;
	private String telefoneRamal;

	@JsonManagedReference
	@OneToMany(mappedBy = "unidadeOrgaoOrigem")
	private List<Movimentacao> listaMovimentacaoOrigem = new ArrayList<>();

	@JsonManagedReference
	@OneToMany(mappedBy = "unidadeOrgaoDestino")
	private List<Movimentacao> listaMovimentacaoDestino = new ArrayList<>();

	@JsonManagedReference
	@OneToMany(mappedBy = "unidadeOrgaoLotacao")
	private List<TecnicoAdministrativo> listaTecnicoAdministrativo = new ArrayList<>();

	public UnidadeOrgao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnidadeOrgao(Integer id, String nomeUnidade, String siglaUnidade, String telefoneRamal,
			List<Movimentacao> listaMovimentacaoOrigem, List<Movimentacao> listaMovimentacaoDestino,
			List<TecnicoAdministrativo> listaTecnicoAdministrativo) {
		super();
		this.id = id;
		this.nomeUnidade = nomeUnidade;
		this.siglaUnidade = siglaUnidade;
		this.telefoneRamal = telefoneRamal;
		this.listaMovimentacaoOrigem = listaMovimentacaoOrigem;
		this.listaMovimentacaoDestino = listaMovimentacaoDestino;
		this.listaTecnicoAdministrativo = listaTecnicoAdministrativo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeUnidade() {
		return nomeUnidade;
	}

	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}

	public String getSiglaUnidade() {
		return siglaUnidade;
	}

	public void setSiglaUnidade(String siglaUnidade) {
		this.siglaUnidade = siglaUnidade;
	}

	public String getTelefoneRamal() {
		return telefoneRamal;
	}

	public void setTelefoneRamal(String telefoneRamal) {
		this.telefoneRamal = telefoneRamal;
	}

	public List<Movimentacao> getListaMovimentacaoOrigem() {
		return listaMovimentacaoOrigem;
	}

	public void setListaMovimentacaoOrigem(List<Movimentacao> listaMovimentacaoOrigem) {
		this.listaMovimentacaoOrigem = listaMovimentacaoOrigem;
	}

	public List<Movimentacao> getListaMovimentacaoDestino() {
		return listaMovimentacaoDestino;
	}

	public void setListaMovimentacaoDestino(List<Movimentacao> listaMovimentacaoDestino) {
		this.listaMovimentacaoDestino = listaMovimentacaoDestino;
	}

	public List<TecnicoAdministrativo> getListaTecnicoAdministrativo() {
		return listaTecnicoAdministrativo;
	}

	public void setListaTecnicoAdministrativo(List<TecnicoAdministrativo> listaTecnicoAdministrativo) {
		this.listaTecnicoAdministrativo = listaTecnicoAdministrativo;
	}

}
