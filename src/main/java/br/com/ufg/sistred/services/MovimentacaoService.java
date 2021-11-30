package br.com.ufg.sistred.services;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

		Movimentacao movimentacao = movimentacaoRepository.findById(id).get();

		return converteEntityToDTO(movimentacao);
		// return movimentacaoRepository.findById(id).get();

	}

	public List<MovimentacaoDTO> findAll() {

		List<Movimentacao> listaMovimentacoes = movimentacaoRepository.findAll();
		List<MovimentacaoDTO> listaMovimentacaoDTO = new ArrayList<MovimentacaoDTO>();

		for (Movimentacao movimentacao : listaMovimentacoes) {

			listaMovimentacaoDTO.add(converteEntityToDTO(movimentacao));

		}

		return listaMovimentacaoDTO;

	}

	public MovimentacaoDTO salvar(MovimentacaoDTO movimentacaoDTO) {

		Movimentacao movimentacao = modelMapper.map(movimentacaoDTO, Movimentacao.class);

		return converteEntityToDTO(movimentacaoRepository.save(movimentacao));

	}

	public void deletar(Integer id) {

		Movimentacao movimentacao = movimentacaoRepository.findById(id).get();
		movimentacaoRepository.delete(movimentacao);
	}

	public Movimentacao atualizar(Integer id, MovimentacaoDTO movimentacaoDTO) {

		Movimentacao movimentacao = modelMapper.map(movimentacaoDTO, Movimentacao.class);

		Movimentacao movimentacaoPre = movimentacaoRepository.getById(id);

		movimentacaoPre = movimentacao;

		movimentacaoRepository.save(movimentacaoPre);

		return movimentacao;
	}

	/**
	 * 
	 * @param movimentacao
	 * @descricao metodo responsavel por converter a entidade movimentacao em
	 *            movimentacaoDTO
	 */
	private MovimentacaoDTO converteEntityToDTO(Movimentacao movimentacao) {

		MovimentacaoDTO movimentacaoDTO = new MovimentacaoDTO();
		GabineteDTO gabineteDTO = new GabineteDTO();
		MouseDTO mouseDTO = new MouseDTO();
		CaboDTO caboDTO = new CaboDTO();
		DispositivoProtecaoDTO dispositivoProtecaoDTO = new DispositivoProtecaoDTO();
		ImpressoraDTO impressoraDTO = new ImpressoraDTO();
		MonitorDTO monitorDTO = new MonitorDTO();
		NotebookDTO notebookDTO = new NotebookDTO();
		TecladoDTO tecladoDTO = new TecladoDTO();
		DispositivoPortatilDTO dispositivoPortatilDTO = new DispositivoPortatilDTO();
		UnidadeOrgaoDTO unidadeOrgaoOrigemDTO = new UnidadeOrgaoDTO();
		UnidadeOrgaoDTO unidadeOrgaoODestinoDTO = new UnidadeOrgaoDTO();

		movimentacaoDTO = modelMapper.map(movimentacao, MovimentacaoDTO.class);
		
		unidadeOrgaoOrigemDTO = modelMapper.map(movimentacao.getUnidadeOrgaoOrigem(), UnidadeOrgaoDTO.class);
		unidadeOrgaoODestinoDTO = modelMapper.map(movimentacao.getUnidadeOrgaoDestino(), UnidadeOrgaoDTO.class);
		movimentacaoDTO.setUnidadeOrgaoOrigemDTO(unidadeOrgaoOrigemDTO);
		movimentacaoDTO.setUnidadeOrgaoDestinoDTO(unidadeOrgaoODestinoDTO);
		

		for (Gabinete gabinete : movimentacao.getListaGabinete()) {

			gabineteDTO = modelMapper.map(gabinete, GabineteDTO.class);

			for (HistoricoAtivo historicoAtivo : gabinete.getListaHistoricoAtivo()) {

				gabineteDTO.getListaHistoricoAtivoDTO().add(modelMapper.map(historicoAtivo, HistoricoAtivoDTO.class));

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

		for (Cabo cabo : movimentacao.getListaCabo()) {

			caboDTO = modelMapper.map(cabo, CaboDTO.class);

			for (HistoricoAtivo historicoAtivo : cabo.getListaHistoricoAtivo()) {

				caboDTO.getListaHistoricoAtivoDTO().add(modelMapper.map(historicoAtivo, HistoricoAtivoDTO.class));

			}

			movimentacaoDTO.getListaCaboDTO().add(caboDTO);

		}

		
		for (DispositivoProtecao dispositivoProtecao : movimentacao.getListaDispositivoProtecao()) {

			dispositivoProtecaoDTO = modelMapper.map(dispositivoProtecao, DispositivoProtecaoDTO.class);

			for (HistoricoAtivo historicoAtivo : dispositivoProtecao.getListaHistoricoAtivo()) {

				dispositivoProtecaoDTO.getListaHistoricoAtivoDTO().add(modelMapper.map(historicoAtivo, HistoricoAtivoDTO.class));

			}

			movimentacaoDTO.getListaDispositivoProtecaoDTO().add(dispositivoProtecaoDTO);

		}
		
		
		for (Impressora impressora : movimentacao.getListaImpressora()) {

			impressoraDTO = modelMapper.map(impressora, ImpressoraDTO.class);

			for (HistoricoAtivo historicoAtivo : impressora.getListaHistoricoAtivo()) {

				impressoraDTO.getListaHistoricoAtivoDTO().add(modelMapper.map(historicoAtivo, HistoricoAtivoDTO.class));

			}

			movimentacaoDTO.getListaImpressoraDTO().add(impressoraDTO);

		}
		
		for (Monitor monitor : movimentacao.getListaMonitor()) {

			monitorDTO = modelMapper.map(monitor, MonitorDTO.class);

			for (HistoricoAtivo historicoAtivo : monitor.getListaHistoricoAtivo()) {

				monitorDTO.getListaHistoricoAtivoDTO().add(modelMapper.map(historicoAtivo, HistoricoAtivoDTO.class));

			}

			movimentacaoDTO.getListaMonitorDTO().add(monitorDTO);

		}
		
		for (Notebook notebook : movimentacao.getListaNotebook()) {

			notebookDTO = modelMapper.map(notebook, NotebookDTO.class);

			for (HistoricoAtivo historicoAtivo : notebook.getListaHistoricoAtivo()) {

				notebookDTO.getListaHistoricoAtivoDTO().add(modelMapper.map(historicoAtivo, HistoricoAtivoDTO.class));

			}

			movimentacaoDTO.getListaNotebookDTO().add(notebookDTO);

		}
		
		for (Teclado teclado : movimentacao.getListaTeclado()) {

			tecladoDTO = modelMapper.map(teclado, TecladoDTO.class);

			for (HistoricoAtivo historicoAtivo : teclado.getListaHistoricoAtivo()) {

				tecladoDTO.getListaHistoricoAtivoDTO().add(modelMapper.map(historicoAtivo, HistoricoAtivoDTO.class));

			}

			movimentacaoDTO.getListaTecladoDTO().add(tecladoDTO);

		}
		
		for (DispositivoPortatil dispositivoPortatil : movimentacao.getListaDispositivoPortatil()) {

			dispositivoPortatilDTO = modelMapper.map(dispositivoPortatil, DispositivoPortatilDTO.class);

			for (HistoricoAtivo historicoAtivo : dispositivoPortatil.getListaHistoricoAtivo()) {

				dispositivoPortatilDTO.getListaHistoricoAtivoDTO().add(modelMapper.map(historicoAtivo, HistoricoAtivoDTO.class));

			}

			movimentacaoDTO.getListaDispositivoPortatilDTO().add(dispositivoPortatilDTO);

		}
		
		return movimentacaoDTO;

	}
}
