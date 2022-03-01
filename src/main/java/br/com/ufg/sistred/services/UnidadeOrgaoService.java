package br.com.ufg.sistred.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufg.sistred.domain.HistoricoAtivo;
import br.com.ufg.sistred.domain.Mouse;
import br.com.ufg.sistred.domain.Movimentacao;
import br.com.ufg.sistred.domain.TecnicoAdministrativo;
import br.com.ufg.sistred.domain.UnidadeOrgao;
import br.com.ufg.sistred.dto.HistoricoAtivoDTO;
import br.com.ufg.sistred.dto.MouseDTO;
import br.com.ufg.sistred.dto.MovimentacaoDTO;
import br.com.ufg.sistred.dto.TecnicoAdministrativoDTO;
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
			
//			for(Movimentacao mov : uo.getListaMovimentacaoDestino()) {
//				unidadeOrgaoDTO.getListaMovimentacaoDestinoDTO().add(modelMapper.map(mov, MovimentacaoDTO.class));
//			}
//			for(Movimentacao mov : uo.getListaMovimentacaoOrigem()) {
//				unidadeOrgaoDTO.getListaMovimentacaoOrigemDTO().add(modelMapper.map(mov, MovimentacaoDTO.class));
//			}
//			for(TecnicoAdministrativo ta : uo.getListaTecnicoAdministrativo()) {
//				unidadeOrgaoDTO.getListaTecnicoAdministrativoDTO().add(modelMapper.map(ta, TecnicoAdministrativoDTO.class));
//			}
			
			listaDTO.add(unidadeOrgaoDTO);
		}

		return listaDTO;
	}
}
