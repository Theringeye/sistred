package br.com.ufg.sistred.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufg.sistred.domain.HistoricoAtivo;
import br.com.ufg.sistred.domain.Monitor;
import br.com.ufg.sistred.domain.Movimentacao;
import br.com.ufg.sistred.dto.HistoricoAtivoDTO;
import br.com.ufg.sistred.dto.MonitorDTO;
import br.com.ufg.sistred.dto.MovimentacaoDTO;
import br.com.ufg.sistred.repositories.MonitorRepository;

@Service
public class MonitorService {

	@Autowired
	private MonitorRepository monitorRepository;

	@Autowired
	private ModelMapper modelMapper;

	public MonitorDTO salvar(MonitorDTO MonitorDTO) {
		Monitor monitor = modelMapper.map(MonitorDTO, Monitor.class);
		return converteEntityToDTO(monitorRepository.save(monitor));
	}

	public MonitorDTO findById(Integer id) {
		Monitor monitor = monitorRepository.findById(id).get();
		return converteEntityToDTO(monitor);
	}

	public List<MonitorDTO> findAll() {
		List<Monitor> listaMonitors = monitorRepository.findAll();

		List<MonitorDTO> listaMonitorsDTO = converteEntityToDTO(listaMonitors);

		return listaMonitorsDTO;
	}

	public void deletar(Integer id) {
		Monitor monitor = monitorRepository.findById(id).get();
		monitorRepository.delete(monitor);

	}

	private MonitorDTO converteEntityToDTO(Monitor monitor) {
		MonitorDTO MonitorDTO = new MonitorDTO();
		MonitorDTO = modelMapper.map(monitor, MonitorDTO.class);
		return MonitorDTO;
	}

	private List<MonitorDTO> converteEntityToDTO(List<Monitor> listaMonitors) {

		MonitorDTO MonitorDTO = new MonitorDTO();
		ArrayList<MonitorDTO> listaMonitorDTO = new ArrayList<MonitorDTO>();

		for (Monitor monitor : listaMonitors) {

			MonitorDTO = modelMapper.map(monitor, MonitorDTO.class);

			for (HistoricoAtivo historicoAtivo : monitor.getListaHistoricoAtivo()) {

				MonitorDTO.getListaHistoricoAtivoDTO().add(modelMapper.map(historicoAtivo, HistoricoAtivoDTO.class));
			}

			for (Movimentacao movimentacao : monitor.getListaMovimentacao()) {

				MonitorDTO.getListaMovimentacaoDTO().add(modelMapper.map(movimentacao, MovimentacaoDTO.class));
			}

			listaMonitorDTO.add(MonitorDTO);
		}

		return listaMonitorDTO;
	}
}
