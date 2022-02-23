package br.com.ufg.sistred.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufg.sistred.domain.UnidadeOrgao;
import br.com.ufg.sistred.dto.UnidadeOrgaoDTO;
import br.com.ufg.sistred.repositories.UnidadeOrgaoRepository;

@Service
public class UnidadeOrgaoService {

	@Autowired
	private UnidadeOrgaoRepository entityRepository;

	@Autowired
	private ModelMapper modelMapper;

	public UnidadeOrgaoDTO salvar(UnidadeOrgaoDTO unidadeOrgaoDTO) {
		UnidadeOrgao uo = modelMapper.map(unidadeOrgaoDTO, UnidadeOrgao.class);
		return converteEntityToDTO(entityRepository.save(uo));
	}

	public UnidadeOrgaoDTO findById(Integer id) {
		UnidadeOrgao uo = entityRepository.findById(id).get();
		return converteEntityToDTO(uo);
	}

	public List<UnidadeOrgaoDTO> findAll() {
		List<UnidadeOrgao> lista = entityRepository.findAll();

		List<UnidadeOrgaoDTO> listaDTO = converteEntityToDTO(lista);

		return listaDTO;
	}

	public void deletar(Integer id) {
		UnidadeOrgao uo = entityRepository.findById(id).get();
		entityRepository.delete(uo);

	}

	private UnidadeOrgaoDTO converteEntityToDTO(UnidadeOrgao uo) {
		UnidadeOrgaoDTO unidadeOrgaoDTO = new UnidadeOrgaoDTO();
		unidadeOrgaoDTO = modelMapper.map(uo, UnidadeOrgaoDTO.class);
		return unidadeOrgaoDTO;
	}

	private List<UnidadeOrgaoDTO> converteEntityToDTO(List<UnidadeOrgao> lista) {

		UnidadeOrgaoDTO unidadeOrgaoDTO = new UnidadeOrgaoDTO();
		ArrayList<UnidadeOrgaoDTO> listaDTO = new ArrayList<UnidadeOrgaoDTO>();

		for (UnidadeOrgao uo : lista) {
			unidadeOrgaoDTO = modelMapper.map(uo, UnidadeOrgaoDTO.class);
			listaDTO.add(unidadeOrgaoDTO);
		}

		return listaDTO;
	}
}
