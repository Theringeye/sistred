package br.com.ufg.sistred.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufg.sistred.domain.Cabo;
import br.com.ufg.sistred.domain.DispositivoPortatil;
import br.com.ufg.sistred.domain.DispositivoProtecao;
import br.com.ufg.sistred.domain.Gabinete;
import br.com.ufg.sistred.domain.HistoricoAtivo;
import br.com.ufg.sistred.domain.Impressora;
import br.com.ufg.sistred.domain.Monitor;
import br.com.ufg.sistred.domain.Mouse;
import br.com.ufg.sistred.domain.Movimentacao;
import br.com.ufg.sistred.domain.Notebook;
import br.com.ufg.sistred.domain.Teclado;
import br.com.ufg.sistred.dto.CaboDTO;
import br.com.ufg.sistred.dto.DispositivoPortatilDTO;
import br.com.ufg.sistred.dto.DispositivoProtecaoDTO;
import br.com.ufg.sistred.dto.GabineteDTO;
import br.com.ufg.sistred.dto.HistoricoAtivoDTO;
import br.com.ufg.sistred.dto.ImpressoraDTO;
import br.com.ufg.sistred.dto.MonitorDTO;
import br.com.ufg.sistred.dto.MouseDTO;
import br.com.ufg.sistred.dto.MovimentacaoDTO;
import br.com.ufg.sistred.dto.NotebookDTO;
import br.com.ufg.sistred.dto.TecladoDTO;
import br.com.ufg.sistred.dto.UnidadeOrgaoDTO;
import br.com.ufg.sistred.repositories.CaboRepository;

@Service
public class CaboService {

	@Autowired
	private CaboRepository caboRepository;

	@Autowired
	private ModelMapper modelMapper;

	public CaboDTO salvar(CaboDTO caboDTO) {
		Cabo cabo = modelMapper.map(caboDTO, Cabo.class);
		return converteEntityToDTO(caboRepository.save(cabo));
	}

	public CaboDTO findById(Integer id) {
		Cabo cabo = caboRepository.findById(id).get();
		return converteEntityToDTO(cabo);
	}

	public List<CaboDTO> findAll() {
		List<Cabo> listaCabos = caboRepository.findAll();

		List<CaboDTO> listaCabosDTO = converteEntityToDTO(listaCabos);

		return listaCabosDTO;
	}

	public void deletar(Integer id) {
		Cabo cabo = caboRepository.findById(id).get();
		caboRepository.delete(cabo);

	}

	private CaboDTO converteEntityToDTO(Cabo cabo) {
		CaboDTO caboDTO = new CaboDTO();
		caboDTO = modelMapper.map(cabo, CaboDTO.class);
		return caboDTO;
	}

	private List<CaboDTO> converteEntityToDTO(List<Cabo> listaCabos) {

		CaboDTO caboDTO = new CaboDTO();
		ArrayList<CaboDTO> listaCaboDTO = new ArrayList<CaboDTO>();

		for (Cabo cabo : listaCabos) {

			caboDTO = modelMapper.map(cabo, CaboDTO.class);

			for (HistoricoAtivo historicoAtivo : cabo.getListaHistoricoAtivo()) {

				caboDTO.getListaHistoricoAtivoDTO().add(modelMapper.map(historicoAtivo, HistoricoAtivoDTO.class));
			}

			for (Movimentacao movimentacao : cabo.getListaMovimentacao()) {

				caboDTO.getListaMovimentacaoDTO().add(modelMapper.map(movimentacao, MovimentacaoDTO.class));
			}

			listaCaboDTO.add(caboDTO);
		}

		return listaCaboDTO;
	}
}
