package br.com.ufg.sistred.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MovimentacaoDTO {

	private Integer id;

	private String tipo;

	private boolean entrada_saida;

	private UnidadeOrgaoDTO unidadeOrgaoOrigemDTO;

	private UnidadeOrgaoDTO unidadeOrgaoDestinoDTO;

	private Timestamp data;

	private String observacao;

	private TecnicoAdministrativoDTO responsavelTecnicoDTO;

	private TecnicoAdministrativoDTO responsavelAdministrativoDTO;

	private List<GabineteDTO> listaGabineteDTO = new ArrayList<>();

	private List<MouseDTO> listaMouseDTO = new ArrayList<>();

	private List<CaboDTO> listaCaboDTO = new ArrayList<>();

	private List<DispositivoProtecaoDTO> listaDispositivoProtecaoDTO = new ArrayList<>();

	private List<ImpressoraDTO> listaImpressoraDTO = new ArrayList<>();

	private List<MonitorDTO> listaMonitorDTO = new ArrayList<>();

	private List<NotebookDTO> listaNotebookDTO = new ArrayList<>();

	private List<TecladoDTO> listaTecladoDTO = new ArrayList<>();

	private List<DispositivoPortatilDTO> listaDispositivoPortatilDTO = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isEntrada_saida() {
		return entrada_saida;
	}

	public void setEntrada_saida(boolean entrada_saida) {
		this.entrada_saida = entrada_saida;
	}

	public UnidadeOrgaoDTO getUnidadeOrgaoOrigemDTO() {
		return unidadeOrgaoOrigemDTO;
	}

	public void setUnidadeOrgaoOrigemDTO(UnidadeOrgaoDTO unidadeOrgaoOrigemDTO) {
		this.unidadeOrgaoOrigemDTO = unidadeOrgaoOrigemDTO;
	}

	public UnidadeOrgaoDTO getUnidadeOrgaoDestinoDTO() {
		return unidadeOrgaoDestinoDTO;
	}

	public void setUnidadeOrgaoDestinoDTO(UnidadeOrgaoDTO unidadeOrgaoDestinoDTO) {
		this.unidadeOrgaoDestinoDTO = unidadeOrgaoDestinoDTO;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public TecnicoAdministrativoDTO getResponsavelTecnicoDTO() {
		return responsavelTecnicoDTO;
	}

	public void setResponsavelTecnicoDTO(TecnicoAdministrativoDTO responsavelTecnicoDTO) {
		this.responsavelTecnicoDTO = responsavelTecnicoDTO;
	}

	public TecnicoAdministrativoDTO getResponsavelAdministrativoDTO() {
		return responsavelAdministrativoDTO;
	}

	public void setResponsavelAdministrativoDTO(TecnicoAdministrativoDTO responsavelAdministrativoDTO) {
		this.responsavelAdministrativoDTO = responsavelAdministrativoDTO;
	}

	public List<GabineteDTO> getListaGabineteDTO() {
		return listaGabineteDTO;
	}

	public void setListaGabineteDTO(List<GabineteDTO> listaGabineteDTO) {
		this.listaGabineteDTO = listaGabineteDTO;
	}

	public List<MouseDTO> getListaMouseDTO() {
		return listaMouseDTO;
	}

	public void setListaMouseDTO(List<MouseDTO> listaMouseDTO) {
		this.listaMouseDTO = listaMouseDTO;
	}

	public List<CaboDTO> getListaCaboDTO() {
		return listaCaboDTO;
	}

	public void setListaCaboDTO(List<CaboDTO> listaCaboDTO) {
		this.listaCaboDTO = listaCaboDTO;
	}

	public List<DispositivoProtecaoDTO> getListaDispositivoProtecaoDTO() {
		return listaDispositivoProtecaoDTO;
	}

	public void setListaDispositivoProtecaoDTO(List<DispositivoProtecaoDTO> listaDispositivoProtecaoDTO) {
		this.listaDispositivoProtecaoDTO = listaDispositivoProtecaoDTO;
	}

	public List<ImpressoraDTO> getListaImpressoraDTO() {
		return listaImpressoraDTO;
	}

	public void setListaImpressoraDTO(List<ImpressoraDTO> listaImpressoraDTO) {
		this.listaImpressoraDTO = listaImpressoraDTO;
	}

	public List<MonitorDTO> getListaMonitorDTO() {
		return listaMonitorDTO;
	}

	public void setListaMonitorDTO(List<MonitorDTO> listaMonitorDTO) {
		this.listaMonitorDTO = listaMonitorDTO;
	}

	public List<NotebookDTO> getListaNotebookDTO() {
		return listaNotebookDTO;
	}

	public void setListaNotebookDTO(List<NotebookDTO> listaNotebookDTO) {
		this.listaNotebookDTO = listaNotebookDTO;
	}

	public List<TecladoDTO> getListaTecladoDTO() {
		return listaTecladoDTO;
	}

	public void setListaTecladoDTO(List<TecladoDTO> listaTecladoDTO) {
		this.listaTecladoDTO = listaTecladoDTO;
	}

	public List<DispositivoPortatilDTO> getListaDispositivoPortatilDTO() {
		return listaDispositivoPortatilDTO;
	}

	public void setListaDispositivoPortatilDTO(List<DispositivoPortatilDTO> listaDispositivoPortatilDTO) {
		this.listaDispositivoPortatilDTO = listaDispositivoPortatilDTO;
	}

}
