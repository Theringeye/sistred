package br.com.ufg.sistred.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TecnicoAdministrativo implements Serializable {

	private static final long serialVersionUID = 6750855684307198172L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nomeTecnico;

	@ManyToOne
	@JoinColumn(name = "unidadeOrgaoLotacao_id")
	private UnidadeOrgao unidadeOrgaoLotacao;

	private String telefoneRamalDepartamentoOrgao;

	@OneToMany(mappedBy = "responsavelTecnico")
	private List<Movimentacao> listaMovimentacaoResponsavelTecnico = new ArrayList<>();

	@OneToMany(mappedBy = "responsavelAdministrativo")
	private List<Movimentacao> listaMovimentacaoResponsavelAdministrativo = new ArrayList<>();

	public TecnicoAdministrativo() {
		super();
	}

	public TecnicoAdministrativo(Integer id, String nomeTecnico, UnidadeOrgao unidadeOrgaoLotacao,
			String telefoneRamalDepartamentoOrgao, List<Movimentacao> listaMovimentacaoResponsavelTecnico,
			List<Movimentacao> listaMovimentacaoResponsavelAdministrativo) {
		super();
		this.id = id;
		this.nomeTecnico = nomeTecnico;
		this.unidadeOrgaoLotacao = unidadeOrgaoLotacao;
		this.telefoneRamalDepartamentoOrgao = telefoneRamalDepartamentoOrgao;
		this.listaMovimentacaoResponsavelTecnico = listaMovimentacaoResponsavelTecnico;
		this.listaMovimentacaoResponsavelAdministrativo = listaMovimentacaoResponsavelAdministrativo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeTecnico() {
		return nomeTecnico;
	}

	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
	}

	public UnidadeOrgao getUnidadeOrgaoLotacao() {
		return unidadeOrgaoLotacao;
	}

	public void setUnidadeOrgaoLotacao(UnidadeOrgao unidadeOrgaoLotacao) {
		this.unidadeOrgaoLotacao = unidadeOrgaoLotacao;
	}

	public String getTelefoneRamalDepartamentoOrgao() {
		return telefoneRamalDepartamentoOrgao;
	}

	public void setTelefoneRamalDepartamentoOrgao(String telefoneRamalDepartamentoOrgao) {
		this.telefoneRamalDepartamentoOrgao = telefoneRamalDepartamentoOrgao;
	}

	public List<Movimentacao> getListaMovimentacaoResponsavelTecnico() {
		return listaMovimentacaoResponsavelTecnico;
	}

	public void setListaMovimentacaoResponsavelTecnico(List<Movimentacao> listaMovimentacaoResponsavelTecnico) {
		this.listaMovimentacaoResponsavelTecnico = listaMovimentacaoResponsavelTecnico;
	}

	public List<Movimentacao> getListaMovimentacaoResponsavelAdministrativo() {
		return listaMovimentacaoResponsavelAdministrativo;
	}

	public void setListaMovimentacaoResponsavelAdministrativo(
			List<Movimentacao> listaMovimentacaoResponsavelAdministrativo) {
		this.listaMovimentacaoResponsavelAdministrativo = listaMovimentacaoResponsavelAdministrativo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TecnicoAdministrativo other = (TecnicoAdministrativo) obj;
		return Objects.equals(id, other.id);
	}

}
