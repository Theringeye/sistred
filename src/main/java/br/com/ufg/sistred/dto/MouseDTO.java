package br.com.ufg.sistred.dto;

import java.util.ArrayList;
import java.util.List;

public class MouseDTO extends CommonDTO {

	private String codigo_identificacao;
	private List<MovimentacaoDTO> listaMovimentacaoDTO = new ArrayList<>();
	private List<HistoricoAtivoDTO> listaHistoricoAtivoDTO = new ArrayList<>();

	public String getCodigo_identificacao() {
		return codigo_identificacao;
	}

	public void setCodigo_identificacao(String codigo_identificacao) {
		this.codigo_identificacao = codigo_identificacao;
	}

	public List<MovimentacaoDTO> getListaMovimentacaoDTO() {
		return listaMovimentacaoDTO;
	}

	public void setListaMovimentacaoDTO(List<MovimentacaoDTO> listaMovimentacaoDTO) {
		this.listaMovimentacaoDTO = listaMovimentacaoDTO;
	}

	public List<HistoricoAtivoDTO> getListaHistoricoAtivoDTO() {
		return listaHistoricoAtivoDTO;
	}

	public void setListaHistoricoAtivoDTO(List<HistoricoAtivoDTO> listaHistoricoAtivoDTO) {
		this.listaHistoricoAtivoDTO = listaHistoricoAtivoDTO;
	}

}
