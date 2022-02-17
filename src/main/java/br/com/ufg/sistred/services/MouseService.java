package br.com.ufg.sistred.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufg.sistred.domain.HistoricoAtivo;
import br.com.ufg.sistred.domain.Mouse;
import br.com.ufg.sistred.domain.Movimentacao;
import br.com.ufg.sistred.dto.HistoricoAtivoDTO;
import br.com.ufg.sistred.dto.MouseDTO;
import br.com.ufg.sistred.dto.MovimentacaoDTO;
import br.com.ufg.sistred.repositories.MouseRepository;

@Service
public class MouseService {

	@Autowired
	private MouseRepository mouseRepository;

	@Autowired
	private ModelMapper modelMapper;

	public MouseDTO salvar(MouseDTO MouseDTO) {
		Mouse mouse = modelMapper.map(MouseDTO, Mouse.class);
		return converteEntityToDTO(mouseRepository.save(mouse));
	}

	public MouseDTO findById(Integer id) {
		Mouse mouse = mouseRepository.findById(id).get();
		return converteEntityToDTO(mouse);
	}

	public List<MouseDTO> findAll() {
		List<Mouse> listaMouses = mouseRepository.findAll();

		List<MouseDTO> listaMousesDTO = converteEntityToDTO(listaMouses);

		return listaMousesDTO;
	}

	public void deletar(Integer id) {
		Mouse mouse = mouseRepository.findById(id).get();
		mouseRepository.delete(mouse);

	}

	private MouseDTO converteEntityToDTO(Mouse mouse) {
		MouseDTO MouseDTO = new MouseDTO();
		MouseDTO = modelMapper.map(mouse, MouseDTO.class);
		return MouseDTO;
	}

	private List<MouseDTO> converteEntityToDTO(List<Mouse> listaMouses) {

		MouseDTO MouseDTO = new MouseDTO();
		ArrayList<MouseDTO> listaMouseDTO = new ArrayList<MouseDTO>();

		for (Mouse mouse : listaMouses) {

			MouseDTO = modelMapper.map(mouse, MouseDTO.class);

			for (HistoricoAtivo historicoAtivo : mouse.getListaHistoricoAtivo()) {

				MouseDTO.getListaHistoricoAtivoDTO().add(modelMapper.map(historicoAtivo, HistoricoAtivoDTO.class));
			}

			for (Movimentacao movimentacao : mouse.getListaMovimentacao()) {

				MouseDTO.getListaMovimentacaoDTO().add(modelMapper.map(movimentacao, MovimentacaoDTO.class));
			}

			listaMouseDTO.add(MouseDTO);
		}

		return listaMouseDTO;
	}
}
