package br.com.ufg.sistred.services;

import java.util.ArrayList;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ufg.sistred.domain.Gabinete;
import br.com.ufg.sistred.domain.HistoricoAtivo;
import br.com.ufg.sistred.domain.Mouse;
import br.com.ufg.sistred.domain.Movimentacao;
import br.com.ufg.sistred.dto.GabineteDTO;
import br.com.ufg.sistred.dto.HistoricoAtivoDTO;
import br.com.ufg.sistred.dto.MouseDTO;
import br.com.ufg.sistred.dto.MovimentacaoDTO;
import br.com.ufg.sistred.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoService {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	@Autowired
	private ModelMapper modelMapper;



	/**
	 * 
	 * O objeto Optional é utilizado para que caso não haja retorno de objeto ele
	 * retorna vazio.
	 */
	public MovimentacaoDTO findById(Integer id) {

		return converteEntityToDTO(movimentacaoRepository.findById(id).get());

	}
	
	

	public Movimentacao save(MovimentacaoDTO movimentacaoDTO) {

		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao = modelMapper.map(movimentacaoDTO, Movimentacao.class);

		movimentacaoRepository.save(movimentacao);

		return movimentacao;
	}
	
	

	private MovimentacaoDTO converteEntityToDTO(Movimentacao movimentacao) {

		MovimentacaoDTO movimentacaoDTO = new MovimentacaoDTO();
		GabineteDTO gabineteDTO = new GabineteDTO();
		MouseDTO mouseDTO = new MouseDTO();

		movimentacaoDTO = modelMapper.map(movimentacao, MovimentacaoDTO.class);

		for (Gabinete gabinete : movimentacao.getListaGabinete()) {

			gabineteDTO = modelMapper.map(gabinete, GabineteDTO.class);

			for (HistoricoAtivo historicoAtivo : gabinete.getListaHistoricoAtivo()) {

				gabineteDTO.getListaHistoricoDTO().add(modelMapper.map(historicoAtivo, HistoricoAtivoDTO.class));

			}

			movimentacaoDTO.getListaGabineteDTO().add(gabineteDTO);

		}

		for (Mouse mouse : movimentacao.getListaMouse()) {

			mouseDTO = modelMapper.map(mouse, MouseDTO.class);

			for (HistoricoAtivo historicoAtivo : mouse.getListaHistoricoAtivo()) {

				mouseDTO.getListaHistoricoAtivoDTO().add(modelMapper.map(historicoAtivo, HistoricoAtivoDTO.class));

			}

			movimentacaoDTO.getListaMouseDTO().add(mouseDTO);

		}

		return movimentacaoDTO;

	}
}
