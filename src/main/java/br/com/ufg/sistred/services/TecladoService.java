package br.com.ufg.sistred.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufg.sistred.domain.HistoricoAtivo;
import br.com.ufg.sistred.domain.Movimentacao;
import br.com.ufg.sistred.domain.Teclado;
import br.com.ufg.sistred.dto.HistoricoAtivoDTO;
import br.com.ufg.sistred.dto.MovimentacaoDTO;
import br.com.ufg.sistred.dto.TecladoDTO;
import br.com.ufg.sistred.repositories.TecladoRepository;

@Service
public class TecladoService {

	@Autowired
	private TecladoRepository entityRepository;

	@Autowired
	private ModelMapper modelMapper;

	public TecladoDTO salvar(TecladoDTO tecladoDTO) {
		Teclado teclado = modelMapper.map(tecladoDTO, Teclado.class);
		return converteEntityToDTO(entityRepository.save(teclado));
	}

	public TecladoDTO findById(Integer id) {
		Teclado teclado = entityRepository.findById(id).get();
		return converteEntityToDTO(teclado);
	}

	public List<TecladoDTO> findAll() {
		List<Teclado> lista = entityRepository.findAll();

		List<TecladoDTO> listaDTO = converteEntityToDTO(lista);

		return listaDTO;
	}

	public void deletar(Integer id) {
		Teclado teclado = entityRepository.findById(id).get();
		entityRepository.delete(teclado);

	}

	private TecladoDTO converteEntityToDTO(Teclado teclado) {
		TecladoDTO tecladoDTO = new TecladoDTO();
		tecladoDTO = modelMapper.map(teclado, TecladoDTO.class);
		return tecladoDTO;
	}

	private List<TecladoDTO> converteEntityToDTO(List<Teclado> lista) {

		TecladoDTO tecladoDTO = new TecladoDTO();
		ArrayList<TecladoDTO> listaDTO = new ArrayList<TecladoDTO>();

		for (Teclado teclado : lista) {

			tecladoDTO = modelMapper.map(teclado, TecladoDTO.class);

			for (HistoricoAtivo historicoAtivo : teclado.getListaHistoricoAtivo()) {

				tecladoDTO.getListaHistoricoAtivoDTO().add(modelMapper.map(historicoAtivo, HistoricoAtivoDTO.class));
			}

			for (Movimentacao movimentacao : teclado.getListaMovimentacao()) {

				tecladoDTO.getListaMovimentacaoDTO().add(modelMapper.map(movimentacao, MovimentacaoDTO.class));
			}

			listaDTO.add(tecladoDTO);
		}

		return listaDTO;
	}
}
