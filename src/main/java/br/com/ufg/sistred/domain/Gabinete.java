package br.com.ufg.sistred.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Gabinete implements Serializable {

	private static final long serialVersionUID = -4693296110568660233L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String processador;
	private String memoria;
	private String tipo_armazenamento;
	private String tamanho_armazenamento;
	private String modelo;
	private String fabricante;
	private String sistema_operacional;
	private String versao_sistema_operacional;
	private String licenca_so;
	private String patrimonio;

	@ManyToMany(mappedBy = "listaGabinete")
	private List<Movimentacao> listaMovimentacao = new ArrayList<>();

	@OneToMany(mappedBy = "gabinete", fetch = FetchType.LAZY)
	private List<HistoricoAtivo> listaHistoricoAtivo = new ArrayList<>();

	public Gabinete() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gabinete(Integer id, String processador, String memoria, String tipo_armazenamento,
			String tamanho_armazenamento, String modelo, String fabricante, String sistema_operacional,
			String versao_sistema_operacional, String licenca_so, String patrimonio,
			List<Movimentacao> listaMovimentacao, List<HistoricoAtivo> listaHistoricoAtivo) {
		super();
		this.id = id;
		this.processador = processador;
		this.memoria = memoria;
		this.tipo_armazenamento = tipo_armazenamento;
		this.tamanho_armazenamento = tamanho_armazenamento;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.sistema_operacional = sistema_operacional;
		this.versao_sistema_operacional = versao_sistema_operacional;
		this.licenca_so = licenca_so;
		this.patrimonio = patrimonio;
		this.listaMovimentacao = listaMovimentacao;
		this.listaHistoricoAtivo = listaHistoricoAtivo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public List<Movimentacao> getListaMovimentacao() {
		return listaMovimentacao;
	}

	public void setListaMovimentacao(List<Movimentacao> listaMovimentacao) {
		this.listaMovimentacao = listaMovimentacao;
	}

	public List<HistoricoAtivo> getListaHistoricoAtivo() {
		return listaHistoricoAtivo;
	}

	public void setListaHistoricoAtivo(List<HistoricoAtivo> listaHistoricoAtivo) {
		this.listaHistoricoAtivo = listaHistoricoAtivo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gabinete other = (Gabinete) obj;
		return Objects.equals(id, other.id);
	}

}
