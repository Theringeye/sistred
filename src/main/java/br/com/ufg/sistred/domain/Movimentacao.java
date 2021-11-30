package br.com.ufg.sistred.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Movimentacao implements Serializable {

	private static final long serialVersionUID = -1097013479949292690L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String tipo;
	private boolean entrada_saida;

	@ManyToOne
	@JoinColumn(name = "unidadeOrgaoOrigem_id")
	private UnidadeOrgao unidadeOrgaoOrigem;

	@ManyToOne
	@JoinColumn(name = "unidadeOrgaoDestino_id")
	private UnidadeOrgao unidadeOrgaoDestino;

	private Timestamp data;
	private String observacao;
	@JsonIgnore
	@ManyToOne(optional = true)
	@JoinColumn(name = "responsavelTecnico_id")
	private TecnicoAdministrativo responsavelTecnico;
	@JsonIgnore
	@ManyToOne(optional = true)
	@JoinColumn(name = "responsavelAdministrativo_id")
	private TecnicoAdministrativo responsavelAdministrativo;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Movimentacao_Gabinete", joinColumns = @JoinColumn(name = "movimentacao_id"), inverseJoinColumns = @JoinColumn(name = "gabinete_id"))
	private List<Gabinete> listaGabinete = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Movimentacao_Mouse", joinColumns = @JoinColumn(name = "movimentacao_id"), inverseJoinColumns = @JoinColumn(name = "mouse_id"))
	private List<Mouse> listaMouse = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Movimentacao_Cabo", joinColumns = @JoinColumn(name = "movimentacao_id"), inverseJoinColumns = @JoinColumn(name = "cabo_id"))
	private List<Cabo> listaCabo = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Movimentacao_DispositivoProtecao", joinColumns = @JoinColumn(name = "movimentacao_id"), inverseJoinColumns = @JoinColumn(name = "dispositivoProtecao_id"))
	private List<DispositivoProtecao> listaDispositivoProtecao = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Movimentacao_Impressora", joinColumns = @JoinColumn(name = "movimentacao_id"), inverseJoinColumns = @JoinColumn(name = "impressora_id"))
	private List<Impressora> listaImpressora = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Movimentacao_Monitor", joinColumns = @JoinColumn(name = "movimentacao_id"), inverseJoinColumns = @JoinColumn(name = "monitor_id"))
	private List<Monitor> listaMonitor = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Movimentacao_Notebook", joinColumns = @JoinColumn(name = "movimentacao_id"), inverseJoinColumns = @JoinColumn(name = "notebook_id"))
	private List<Notebook> listaNotebook = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Movimentacao_Teclado", joinColumns = @JoinColumn(name = "movimentacao_id"), inverseJoinColumns = @JoinColumn(name = "teclado_id"))
	private List<Teclado> listaTeclado = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Movimentacao_DispositivoPortatil", joinColumns = @JoinColumn(name = "movimentacao_id"), inverseJoinColumns = @JoinColumn(name = "dispositivoPortatil_id"))
	private List<DispositivoPortatil> listaDispositivoPortatil = new ArrayList<>();

	public Movimentacao() {
		super();
	}

	public Movimentacao(Integer id, String tipo, boolean entrada_saida, UnidadeOrgao unidadeOrgaoOrigem,
			UnidadeOrgao unidadeOrgaoDestino, Timestamp data, String observacao,
			TecnicoAdministrativo responsavelTecnico, TecnicoAdministrativo responsavelAdministrativo,
			List<Gabinete> listaGabinete, List<Mouse> listaMouse, List<Cabo> listaCabo,
			List<DispositivoProtecao> listaDispositivoProtecao, List<Impressora> listaImpressora,
			List<Monitor> listaMonitor, List<Notebook> listaNotebook, List<Teclado> listaTeclado,
			List<DispositivoPortatil> listaDispositivoPortatil) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.entrada_saida = entrada_saida;
		this.unidadeOrgaoOrigem = unidadeOrgaoOrigem;
		this.unidadeOrgaoDestino = unidadeOrgaoDestino;
		this.data = data;
		this.observacao = observacao;
		this.responsavelTecnico = responsavelTecnico;
		this.responsavelAdministrativo = responsavelAdministrativo;
		this.listaGabinete = listaGabinete;
		this.listaMouse = listaMouse;
		this.listaCabo = listaCabo;
		this.listaDispositivoProtecao = listaDispositivoProtecao;
		this.listaImpressora = listaImpressora;
		this.listaMonitor = listaMonitor;
		this.listaNotebook = listaNotebook;
		this.listaTeclado = listaTeclado;
		this.listaDispositivoPortatil = listaDispositivoPortatil;
	}

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

	public UnidadeOrgao getUnidadeOrgaoOrigem() {
		return unidadeOrgaoOrigem;
	}

	public void setUnidadeOrgaoOrigem(UnidadeOrgao unidadeOrgaoOrigem) {
		this.unidadeOrgaoOrigem = unidadeOrgaoOrigem;
	}

	public UnidadeOrgao getUnidadeOrgaoDestino() {
		return unidadeOrgaoDestino;
	}

	public void setUnidadeOrgaoDestino(UnidadeOrgao unidadeOrgaoDestino) {
		this.unidadeOrgaoDestino = unidadeOrgaoDestino;
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

	public TecnicoAdministrativo getResponsavelTecnico() {
		return responsavelTecnico;
	}

	public void setResponsavelTecnico(TecnicoAdministrativo responsavelTecnico) {
		this.responsavelTecnico = responsavelTecnico;
	}

	public TecnicoAdministrativo getResponsavelAdministrativo() {
		return responsavelAdministrativo;
	}

	public void setResponsavelAdministrativo(TecnicoAdministrativo responsavelAdministrativo) {
		this.responsavelAdministrativo = responsavelAdministrativo;
	}

	public List<Gabinete> getListaGabinete() {
		return listaGabinete;
	}

	public void setListaGabinete(List<Gabinete> listaGabinete) {
		this.listaGabinete = listaGabinete;
	}

	public List<Mouse> getListaMouse() {
		return listaMouse;
	}

	public void setListaMouse(List<Mouse> listaMouse) {
		this.listaMouse = listaMouse;
	}

	public List<Cabo> getListaCabo() {
		return listaCabo;
	}

	public void setListaCabo(List<Cabo> listaCabo) {
		this.listaCabo = listaCabo;
	}

	public List<DispositivoProtecao> getListaDispositivoProtecao() {
		return listaDispositivoProtecao;
	}

	public void setListaDispositivoProtecao(List<DispositivoProtecao> listaDispositivoProtecao) {
		this.listaDispositivoProtecao = listaDispositivoProtecao;
	}

	public List<Impressora> getListaImpressora() {
		return listaImpressora;
	}

	public void setListaImpressora(List<Impressora> listaImpressora) {
		this.listaImpressora = listaImpressora;
	}

	public List<Monitor> getListaMonitor() {
		return listaMonitor;
	}

	public void setListaMonitor(List<Monitor> listaMonitor) {
		this.listaMonitor = listaMonitor;
	}

	public List<Notebook> getListaNotebook() {
		return listaNotebook;
	}

	public void setListaNotebook(List<Notebook> listaNotebook) {
		this.listaNotebook = listaNotebook;
	}

	public List<Teclado> getListaTeclado() {
		return listaTeclado;
	}

	public void setListaTeclado(List<Teclado> listaTeclado) {
		this.listaTeclado = listaTeclado;
	}

	public List<DispositivoPortatil> getListaDispositivoPortatil() {
		return listaDispositivoPortatil;
	}

	public void setListaDispositivoPortatil(List<DispositivoPortatil> listaDispositivoPortatil) {
		this.listaDispositivoPortatil = listaDispositivoPortatil;
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
		Movimentacao other = (Movimentacao) obj;
		return Objects.equals(id, other.id);
	}

}