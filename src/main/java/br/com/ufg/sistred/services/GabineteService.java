package br.com.ufg.sistred.services;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.ufg.sistred.domain.Gabinete;
import br.com.ufg.sistred.domain.HistoricoAtivo;
import br.com.ufg.sistred.domain.Movimentacao;
import br.com.ufg.sistred.dto.GabineteDTO;
import br.com.ufg.sistred.dto.HistoricoAtivoDTO;
import br.com.ufg.sistred.dto.MovimentacaoDTO;
import br.com.ufg.sistred.repositories.GabineteRepository;

@Service
public class GabineteService {	
	
	@Autowired
	private GabineteRepository entityRepository;

	@Autowired
	private ModelMapper modelMapper;

	public GabineteDTO salvar(GabineteDTO gabineteDTO) {
		Gabinete gabinete = modelMapper.map(gabineteDTO, Gabinete.class);
		return converteEntityToDTO(entityRepository.save(gabinete));
	}

	public GabineteDTO findById(Integer id) {
		Gabinete gabinete = entityRepository.findById(id).get();
		return converteEntityToDTO(gabinete);
	}

	public List<GabineteDTO> findAll() {
		List<Gabinete> lista = entityRepository.findAll();

		List<GabineteDTO> listaDTO = converteEntityToDTO(lista);

		return listaDTO;
	}

	public void deletar(Integer id) {
		Gabinete gabinete = entityRepository.findById(id).get();
		entityRepository.delete(gabinete);

	}

	private GabineteDTO converteEntityToDTO(Gabinete gabinete) {
		GabineteDTO gabineteDTO = new GabineteDTO();
		gabineteDTO = modelMapper.map(gabinete, GabineteDTO.class);
		return gabineteDTO;
	}

	private List<GabineteDTO> converteEntityToDTO(List<Gabinete> lista) {

		GabineteDTO gabineteDTO = new GabineteDTO();
		ArrayList<GabineteDTO> listaDTO = new ArrayList<GabineteDTO>();

		for (Gabinete gabinete : lista) {

			gabineteDTO = modelMapper.map(gabinete, GabineteDTO.class);

			for (HistoricoAtivo historicoAtivo : gabinete.getListaHistoricoAtivo()) {

				gabineteDTO.getListaHistoricoAtivoDTO().add(modelMapper.map(historicoAtivo, HistoricoAtivoDTO.class));
			}

			for (Movimentacao movimentacao : gabinete.getListaMovimentacao()) {

				gabineteDTO.getListaMovimentacaoDTO().add(modelMapper.map(movimentacao, MovimentacaoDTO.class));
			}

			listaDTO.add(gabineteDTO);
		}

		return listaDTO;
	}

}
