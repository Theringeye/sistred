package br.com.ufg.sistred.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.ufg.sistred.domain.UnidadeOrgao;

public class TecnicoAdministrativoDTO {

	private Integer id;
	private String nomeTecnico;
	private UnidadeOrgaoDTO unidadeOrgaoLotacaoDTO;
	private String telefoneRamalDepartamentoOrgao;
	private List<MovimentacaoDTO> listaMovimentacaoResponsavelTecnicoDTO = new ArrayList<>();
	private List<MovimentacaoDTO> listaMovimentacaoResponsavelAdministrativoDTO = new ArrayList<>();
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
	public UnidadeOrgaoDTO getUnidadeOrgaoLotacaoDTO() {
		return unidadeOrgaoLotacaoDTO;
	}
	public void setUnidadeOrgaoLotacaoDTO(UnidadeOrgaoDTO unidadeOrgaoLotacaoDTO) {
		this.unidadeOrgaoLotacaoDTO = unidadeOrgaoLotacaoDTO;
	}
	public String getTelefoneRamalDepartamentoOrgao() {
		return telefoneRamalDepartamentoOrgao;
	}
	public void setTelefoneRamalDepartamentoOrgao(String telefoneRamalDepartamentoOrgao) {
		this.telefoneRamalDepartamentoOrgao = telefoneRamalDepartamentoOrgao;
	}
	public List<MovimentacaoDTO> getListaMovimentacaoResponsavelTecnicoDTO() {
		return listaMovimentacaoResponsavelTecnicoDTO;
	}
	public void setListaMovimentacaoResponsavelTecnicoDTO(List<MovimentacaoDTO> listaMovimentacaoResponsavelTecnicoDTO) {
		this.listaMovimentacaoResponsavelTecnicoDTO = listaMovimentacaoResponsavelTecnicoDTO;
	}
	public List<MovimentacaoDTO> getListaMovimentacaoResponsavelAdministrativoDTO() {
		return listaMovimentacaoResponsavelAdministrativoDTO;
	}
	public void setListaMovimentacaoResponsavelAdministrativoDTO(
			List<MovimentacaoDTO> listaMovimentacaoResponsavelAdministrativoDTO) {
		this.listaMovimentacaoResponsavelAdministrativoDTO = listaMovimentacaoResponsavelAdministrativoDTO;
	}

	

}
