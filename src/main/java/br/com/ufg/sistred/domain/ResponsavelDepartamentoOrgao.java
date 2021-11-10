package br.com.ufg.sistred.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ResponsavelDepartamentoOrgao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nomeResponsavel;
	private String nomeOrgao;
	private String siglaOrgao;
	private String telefoneRamalDepartamentoOrgao;

	@OneToMany(mappedBy = "responsavelDepartamentoOrgao")
	private List<Movimentacao> listaMovimentacao = new ArrayList<>();

	public ResponsavelDepartamentoOrgao() {
		super();
	}

	public ResponsavelDepartamentoOrgao(Integer id, String nomeResponsavel, String nomeOrgao, String siglaOrgao,
			String telefoneRamalDepartamentoOrgao, List<Movimentacao> listaMovimentacao) {
		super();
		this.id = id;
		this.nomeResponsavel = nomeResponsavel;
		this.nomeOrgao = nomeOrgao;
		this.siglaOrgao = siglaOrgao;
		this.telefoneRamalDepartamentoOrgao = telefoneRamalDepartamentoOrgao;
		this.listaMovimentacao = listaMovimentacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getNomeOrgao() {
		return nomeOrgao;
	}

	public void setNomeOrgao(String nomeOrgao) {
		this.nomeOrgao = nomeOrgao;
	}

	public String getSiglaOrgao() {
		return siglaOrgao;
	}

	public void setSiglaOrgao(String siglaOrgao) {
		this.siglaOrgao = siglaOrgao;
	}

	public String getTelefoneRamalDepartamentoOrgao() {
		return telefoneRamalDepartamentoOrgao;
	}

	public void setTelefoneRamalDepartamentoOrgao(String telefoneRamalDepartamentoOrgao) {
		this.telefoneRamalDepartamentoOrgao = telefoneRamalDepartamentoOrgao;
	}

	public List<Movimentacao> getListaMovimentacao() {
		return listaMovimentacao;
	}

	public void setListaMovimentacao(List<Movimentacao> listaMovimentacao) {
		this.listaMovimentacao = listaMovimentacao;
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
		ResponsavelDepartamentoOrgao other = (ResponsavelDepartamentoOrgao) obj;
		return Objects.equals(id, other.id);
	}

}
