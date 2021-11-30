package br.com.ufg.sistred.dto;

import java.util.ArrayList;
import java.util.List;

public class DispositivoProtecaoDTO extends CommonDTO {

	private String tipo;
	private List<MovimentacaoDTO> listaMovimentacaoDTO = new ArrayList<>();
	private List<HistoricoAtivoDTO> listaHistoricoAtivoDTO = new ArrayList<>();

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
