package br.com.ufg.sistred.dto;

import java.util.ArrayList;
import java.util.List;

public class UnidadeOrgaoDTO {

	private Integer id;
	private String nomeUnidade;
	private String siglaUnidade;
	private String telefoneRamal;
	private List<MovimentacaoDTO> listaMovimentacaoOrigemDTO = new ArrayList<>();
	private List<MovimentacaoDTO> listaMovimentacaoDestinoDTO = new ArrayList<>();
	private List<TecnicoAdministrativoDTO> listaTecnicoAdministrativoDTO = new ArrayList<>();

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

	public List<MovimentacaoDTO> getListaMovimentacaoOrigemDTO() {
		return listaMovimentacaoOrigemDTO;
	}

	public void setListaMovimentacaoOrigemDTO(List<MovimentacaoDTO> listaMovimentacaoOrigemDTO) {
		this.listaMovimentacaoOrigemDTO = listaMovimentacaoOrigemDTO;
	}

	public List<MovimentacaoDTO> getListaMovimentacaoDestinoDTO() {
		return listaMovimentacaoDestinoDTO;
	}

	public void setListaMovimentacaoDestinoDTO(List<MovimentacaoDTO> listaMovimentacaoDestinoDTO) {
		this.listaMovimentacaoDestinoDTO = listaMovimentacaoDestinoDTO;
	}

	public List<TecnicoAdministrativoDTO> getListaTecnicoAdministrativoDTO() {
		return listaTecnicoAdministrativoDTO;
	}

	public void setListaTecnicoAdministrativoDTO(List<TecnicoAdministrativoDTO> listaTecnicoAdministrativoDTO) {
		this.listaTecnicoAdministrativoDTO = listaTecnicoAdministrativoDTO;
	}

}
