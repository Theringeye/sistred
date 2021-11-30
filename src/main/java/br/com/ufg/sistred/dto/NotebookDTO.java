package br.com.ufg.sistred.dto;

import java.util.ArrayList;
import java.util.List;

public class NotebookDTO extends CommonDTO{

	
	private String processador;
	private String memoria;
	private String tipo_armazenamento;
	private String tamanho_armazenamento;
	private String sistema_operacional;
	private String versao_sistema_operacional;
	private String licenca_so;
	private List<MovimentacaoDTO> listaMovimentacaoDTO = new ArrayList<>();
	private List<HistoricoAtivoDTO> listaHistoricoAtivoDTO = new ArrayList<>();

	
	
	

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getTipo_armazenamento() {
		return tipo_armazenamento;
	}

	public void setTipo_armazenamento(String tipo_armazenamento) {
		this.tipo_armazenamento = tipo_armazenamento;
	}

	public String getTamanho_armazenamento() {
		return tamanho_armazenamento;
	}

	public void setTamanho_armazenamento(String tamanho_armazenamento) {
		this.tamanho_armazenamento = tamanho_armazenamento;
	}

	public String getSistema_operacional() {
		return sistema_operacional;
	}

	public void setSistema_operacional(String sistema_operacional) {
		this.sistema_operacional = sistema_operacional;
	}

	public String getVersao_sistema_operacional() {
		return versao_sistema_operacional;
	}

	public void setVersao_sistema_operacional(String versao_sistema_operacional) {
		this.versao_sistema_operacional = versao_sistema_operacional;
	}

	public String getLicenca_so() {
		return licenca_so;
	}

	public void setLicenca_so(String licenca_so) {
		this.licenca_so = licenca_so;
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
