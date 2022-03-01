package br.com.ufg.sistred.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufg.sistred.domain.Movimentacao;
import br.com.ufg.sistred.domain.TecnicoAdministrativo;
import br.com.ufg.sistred.domain.UnidadeOrgao;
import br.com.ufg.sistred.dto.MovimentacaoDTO;
import br.com.ufg.sistred.dto.TecnicoAdministrativoDTO;
import br.com.ufg.sistred.repositories.TecnicoAdministrativoRepository;

@Service
public class TecnicoAdministrativoService {

	@Autowired
	private TecnicoAdministrativoRepository taRepository;

	@Autowired
	private ModelMapper modelMapper;

	public TecnicoAdministrativoDTO salvar(TecnicoAdministrativoDTO taDTO) {
		TecnicoAdministrativo ta = modelMapper.map(taDTO, TecnicoAdministrativo.class);
		return converteEntityToDTO(taRepository.save(ta));
	}

	public TecnicoAdministrativoDTO findById(Integer id) {
		TecnicoAdministrativo ta = taRepository.findById(id).get();
		return converteEntityToDTO(ta);
	}

	public List<TecnicoAdministrativoDTO> findAll() {
		List<TecnicoAdministrativo> listaTecnicoAdministrativos = taRepository.findAll();
		List<TecnicoAdministrativoDTO> listaTecnicoAdministrativosDTO = converteEntityToDTO(listaTecnicoAdministrativos);
		return listaTecnicoAdministrativosDTO;
	}

	public void deletar(Integer id) {
		TecnicoAdministrativo ta = taRepository.findById(id).get();
		taRepository.delete(ta);
	}

	private TecnicoAdministrativoDTO converteEntityToDTO(TecnicoAdministrativo ta) {
		TecnicoAdministrativoDTO taDTO = new TecnicoAdministrativoDTO();
		taDTO = modelMapper.map(ta, TecnicoAdministrativoDTO.class);
		return taDTO;
	}

	private List<TecnicoAdministrativoDTO> converteEntityToDTO(List<TecnicoAdministrativo> listaTecnicoAdministrativos) {

		TecnicoAdministrativoDTO taDTO = new TecnicoAdministrativoDTO();
		ArrayList<TecnicoAdministrativoDTO> listaTecnicoAdministrativoDTO = new ArrayList<TecnicoAdministrativoDTO>();

		
		for (TecnicoAdministrativo ta : listaTecnicoAdministrativos) {

			taDTO = modelMapper.map(ta, TecnicoAdministrativoDTO.class);

			taDTO.setUnidadeOrgaoLotacao(ta.getUnidadeOrgaoLotacao());
			
			for (Movimentacao mov : ta.getListaMovimentacaoResponsavelTecnico()) {
				taDTO.getListaMovimentacaoResponsavelTecnicoDTO().add(modelMapper.map(mov, MovimentacaoDTO.class));
			}

			for (Movimentacao movimentacao : ta.getListaMovimentacaoResponsavelAdministrativo()) {

				taDTO.getListaMovimentacaoResponsavelAdministrativoDTO().add(modelMapper.map(movimentacao, MovimentacaoDTO.class));
			}

			listaTecnicoAdministrativoDTO.add(taDTO);
		}

		return listaTecnicoAdministrativoDTO;
	}
}
