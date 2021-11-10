package br.com.ufg.sistred.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.ufg.sistred.domain.HistoricoAtivo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MouseDTO {

	private Integer id;
	private String estado;
	private String modelo;
	private String fabricante;
	private String codigo_identificacao;
	private List<HistoricoAtivoDTO> listaHistoricoAtivoDTO = new ArrayList<>();
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
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getCodigo_identificacao() {
		return codigo_identificacao;
	}
	public void setCodigo_identificacao(String codigo_identificacao) {
		this.codigo_identificacao = codigo_identificacao;
	}
	public List<HistoricoAtivoDTO> getListaHistoricoAtivoDTO() {
		return listaHistoricoAtivoDTO;
	}
	public void setListaHistoricoAtivoDTO(List<HistoricoAtivoDTO> listaHistoricoAtivoDTO) {
		this.listaHistoricoAtivoDTO = listaHistoricoAtivoDTO;
	}
	
	
	
}
