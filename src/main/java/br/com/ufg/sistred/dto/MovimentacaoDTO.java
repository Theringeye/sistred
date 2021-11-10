package br.com.ufg.sistred.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.ufg.sistred.domain.Mouse;
import lombok.Getter;
import lombok.Setter;


public class MovimentacaoDTO {

	private Integer id;

	private String tipo;

	private String origem;

	private String destino;

	private Timestamp data;

	private String observacao;

	private ArrayList<GabineteDTO> listaGabineteDTO = new ArrayList();

	private List<MouseDTO> listaMouseDTO = new ArrayList<>();

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

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
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

	public ArrayList<GabineteDTO> getListaGabineteDTO() {
		return listaGabineteDTO;
	}

	public void setListaGabineteDTO(ArrayList<GabineteDTO> listaGabineteDTO) {
		this.listaGabineteDTO = listaGabineteDTO;
	}

	public List<MouseDTO> getListaMouseDTO() {
		return listaMouseDTO;
	}

	public void setListaMouseDTO(List<MouseDTO> listaMouseDTO) {
		this.listaMouseDTO = listaMouseDTO;
	}

}
