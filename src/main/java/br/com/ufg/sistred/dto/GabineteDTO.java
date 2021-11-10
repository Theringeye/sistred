package br.com.ufg.sistred.dto;

import java.util.ArrayList;

public class GabineteDTO {

	private Integer id;
	private String estado;
	private String processador;
	private String memoria;
	private String sistema_operacional;
	private String disco_rigido;
	private String licenca;
	private String patrimonio;
	private ArrayList<HistoricoAtivoDTO> listaHistoricoDTO = new ArrayList<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
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
	public String getSistema_operacional() {
		return sistema_operacional;
	}
	public void setSistema_operacional(String sistema_operacional) {
		this.sistema_operacional = sistema_operacional;
	}
	public String getDisco_rigido() {
		return disco_rigido;
	}
	public void setDisco_rigido(String disco_rigido) {
		this.disco_rigido = disco_rigido;
	}
	public String getLicenca() {
		return licenca;
	}
	public void setLicenca(String licenca) {
		this.licenca = licenca;
	}
	public String getPatrimonio() {
		return patrimonio;
	}
	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}
	public ArrayList<HistoricoAtivoDTO> getListaHistoricoDTO() {
		return listaHistoricoDTO;
	}
	public void setListaHistoricoDTO(ArrayList<HistoricoAtivoDTO> listaHistoricoDTO) {
		this.listaHistoricoDTO = listaHistoricoDTO;
	}



}
