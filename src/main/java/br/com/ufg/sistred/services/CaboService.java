package br.com.ufg.sistred.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufg.sistred.domain.Cabo;
import br.com.ufg.sistred.dto.CaboDTO;
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

	private CaboDTO converteEntityToDTO(Cabo cabo) {
		CaboDTO caboDTO = new CaboDTO();
		caboDTO = modelMapper.map(cabo, CaboDTO.class);
		return caboDTO;
	}

	public CaboDTO findById(Integer id) {
		Cabo cabo = caboRepository.findById(id).get();
		return converteEntityToDTO(cabo);
	}

	public List<CaboDTO> findAll() {
		List<Cabo> listaCabos = caboRepository.findAll();
		List<CaboDTO> listaCabosDTO = new ArrayList<CaboDTO>();

		for (Cabo cabo : listaCabos) {
			System.out.println("ID: "+cabo.getId()+" Fabricante: "+cabo.getFabricante());
			listaCabosDTO.add(converteEntityToDTO(cabo));
		}
		return listaCabosDTO;	
	}

	public void deletar(Integer id) {
		Cabo cabo = caboRepository.findById(id).get();
		caboRepository.delete(cabo);
		
	}

}
