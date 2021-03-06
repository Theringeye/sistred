package br.com.ufg.sistred.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufg.sistred.domain.Cabo;
import br.com.ufg.sistred.domain.Gabinete;
import br.com.ufg.sistred.domain.HistoricoAtivo;
import br.com.ufg.sistred.domain.Monitor;
import br.com.ufg.sistred.domain.Mouse;
import br.com.ufg.sistred.domain.Movimentacao;
import br.com.ufg.sistred.domain.Teclado;
import br.com.ufg.sistred.domain.TecnicoAdministrativo;
import br.com.ufg.sistred.domain.UnidadeOrgao;
import br.com.ufg.sistred.domain.Usuario;
import br.com.ufg.sistred.repositories.CaboRepository;
import br.com.ufg.sistred.repositories.GabineteRepository;
import br.com.ufg.sistred.repositories.HistoricoAtivoRepository;
import br.com.ufg.sistred.repositories.MonitorRepository;
import br.com.ufg.sistred.repositories.MouseRepository;
import br.com.ufg.sistred.repositories.MovimentacaoRepository;
import br.com.ufg.sistred.repositories.TecladoRepository;
import br.com.ufg.sistred.repositories.TecnicoAdministrativoRepository;
import br.com.ufg.sistred.repositories.UnidadeOrgaoRepository;
import br.com.ufg.sistred.repositories.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	@Autowired
	private GabineteRepository gabineteRepository;
	@Autowired
	private MouseRepository mouseRepository;
	@Autowired
	private CaboRepository caboRepository;
	@Autowired
	private UnidadeOrgaoRepository unidadeOrgaoRepository;
	@Autowired
	private TecnicoAdministrativoRepository tecnicoAdministrativoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private HistoricoAtivoRepository historicoAtivoRepository;
	@Autowired
	private TecladoRepository tecladoRepository;
	@Autowired
	private MonitorRepository monitorRepository;


	public void instanciaBancoDeDados() {

		Usuario usuario = new Usuario(null, "ericson", "$2a$10$3wI9N2GiSmi2WSZ2FhNAAeWcwRwwHtAg2BG3wvZHfq2uHUprCVZBe");

		UnidadeOrgao unidadeOrgao1 = new UnidadeOrgao(null, "Centro de Recursos Computacionais", "CERCOMP", "1351", null, null, null);
		UnidadeOrgao unidadeOrgao2 = new UnidadeOrgao(null, "Diretoria de Log??stica", "DLOG", "1019", null, null, null);

		TecnicoAdministrativo tecnicoAdministrativo = new TecnicoAdministrativo(null, "Ericson", null, "452342534",
				null, null);
		TecnicoAdministrativo tecnicoAdministrativo2 = new TecnicoAdministrativo(null, "Murilo", null, "1351",
				null, null);

		Gabinete gabinete1 = new Gabinete("I5", "8GB", "SSD", "1TB", "WINDOWS", "10", "45234523452345234", null, null);

		// gabinete1.setId(null);
		gabinete1.setFabricante("fabricante1");
		gabinete1.setModelo("modelo1");
		gabinete1.setPatrimonio("45345234");

		Gabinete gabinete2 = new Gabinete("I7", "16GB", "SSD", "1TB", "WINDOWS", "10", "784gffgsdf", null, null);

		gabinete2.setId(null);
		gabinete2.setFabricante("fabricante1");
		gabinete2.setModelo("modelo1");
		gabinete2.setPatrimonio("45345234");

		Mouse mouse1 = new Mouse("wqe3542", null, null);

		mouse1.setFabricante("fabricantemosue1");
		mouse1.setModelo("usb");

		Mouse mouse2 = new Mouse("testeok", null, null);

		mouse2.setFabricante("fabricantemosue2");
		mouse2.setModelo("usb2");
		
		/*
		 * MONITORES
		 * */
		
		Monitor monitor1 = new Monitor("20", null, null);
		Monitor monitor2 = new Monitor("19", null, null);
		monitor1.setFabricante("Dell");
		monitor2.setFabricante("HP");

		/*
		 * mouse1.setFabricante("fabricante1"); mouse1.setModelo("modelo1");
		 * mouse1.setPatrimonio("45345234");
		 */

		Cabo cabo1 = new Cabo(null, "y", "sony", null, null);
		Cabo cabo2 = new Cabo(null, "VGA", "dell", null, null);
		Cabo cabo3 = new Cabo(null, "Display Port", "hp", null, null);
		
		Teclado tec1 = new Teclado("DELLTECLADO", "DELL", "711095","ABNT-BR", null, null);
		Teclado tec2 = new Teclado("HPTECLADO", "HP", "728895","ABNT-EUA", null, null);

		ArrayList<Gabinete> listaGabinete = new ArrayList<>();
		ArrayList<Mouse> listaMouse = new ArrayList<>();
		ArrayList<Cabo> listaCabo = new ArrayList<>();
		ArrayList<Teclado> listaTeclado = new ArrayList<>();
		ArrayList<Monitor> listaMonitor = new ArrayList<>();

		listaGabinete.add(gabinete1);
		listaGabinete.add(gabinete2);
		listaMouse.add(mouse1);
		listaMouse.add(mouse2);
		listaCabo.add(cabo1);
		listaCabo.add(cabo2);
		listaCabo.add(cabo3);
		listaTeclado.add(tec1);
		listaTeclado.add(tec2);
		listaMonitor.add(monitor1);
		listaMonitor.add(monitor2);

		// movimentacao.getGabinetes().addAll(Arrays.asList(gabinete));

		usuarioRepository.saveAll(Arrays.asList(usuario));
		gabineteRepository.saveAll(Arrays.asList(gabinete1));
		gabineteRepository.saveAll(Arrays.asList(gabinete2));
		mouseRepository.saveAll(Arrays.asList(mouse1));
		mouseRepository.saveAll(Arrays.asList(mouse2));
		caboRepository.saveAll(Arrays.asList(cabo1));
		caboRepository.saveAll(Arrays.asList(cabo2));
		caboRepository.saveAll(Arrays.asList(cabo3));
		unidadeOrgaoRepository.saveAll(Arrays.asList(unidadeOrgao1, unidadeOrgao2));
		tecnicoAdministrativo.setUnidadeOrgaoLotacao(unidadeOrgao1);
		tecnicoAdministrativo2.setUnidadeOrgaoLotacao(unidadeOrgao2);
		tecnicoAdministrativoRepository.saveAll(Arrays.asList(tecnicoAdministrativo, tecnicoAdministrativo2));
		tecladoRepository.saveAll(Arrays.asList(tec1));
		tecladoRepository.saveAll(Arrays.asList(tec2));
		monitorRepository.saveAll(Arrays.asList(monitor1, monitor2));

		/*
		 * public Movimentacao(Integer id, String tipo, String origem, String destino,
		 * Timestamp data, String observacao, TecnicoAdministrativo
		 * responsavelDepartamentoOrgao, List<Gabinete> listaGabinete, List<Mouse>
		 * listaMouse)
		 */

		Movimentacao movimentacao = new Movimentacao(null, "recolhimento", true, unidadeOrgao1, // origem
				unidadeOrgao1, // destino
				new Timestamp(0), "OBSERVACAO", tecnicoAdministrativo, // tecnico
				tecnicoAdministrativo, // administrativo
				listaGabinete, listaMouse, listaCabo, null, null, null, null, null, null);

		movimentacaoRepository.saveAll(Arrays.asList(movimentacao));

		/*
		 * Movimentacao movimentacao2 = new Movimentacao(null, "distribuicao",
		 * "DLOG","DCOM" ,new Timestamp(0),"TESTE", responsavelDepartamentoOrgao,
		 * listaGabinete2,null);
		 * 
		 * movimentacaoRepository.saveAll(Arrays.asList(movimentacao2));
		 */

		HistoricoAtivo historicoGabinete1 = new HistoricoAtivo(null, "funcionando gab 1", new Timestamp(0), gabinete1,
				null, null, null, null, null, null, null, null);

		HistoricoAtivo historicoGabinete2 = new HistoricoAtivo(null, "funcionando gab 2", new Timestamp(0), gabinete2,
				null, null, null, null, null, null, null, null);

		HistoricoAtivo historicoMouse1 = new HistoricoAtivo(null, "funcionando mouse 1", new Timestamp(0), null, mouse1,
				null, null, null, null, null, null, null);

		HistoricoAtivo historicoMouse2 = new HistoricoAtivo(null, "com defeito", new Timestamp(0), null, mouse2, null,
				null, null, null, null, null, null);
		
		HistoricoAtivo historicoCabo1 = new HistoricoAtivo(null, "com defeito", new Timestamp(0), null, null, cabo1,
				null, null, null, null, null, null);
		
		HistoricoAtivo historicoCabo2 = new HistoricoAtivo(null, "funcionando2", new Timestamp(0), null, null, cabo2,
				null, null, null, null, null, null);
		
		HistoricoAtivo historicoCabo3 = new HistoricoAtivo(null, "funcionando3", new Timestamp(0), null, null, cabo3,
				null, null, null, null, null, null);
		

		historicoAtivoRepository.save(historicoGabinete1);

		historicoAtivoRepository.save(historicoGabinete2);

		historicoAtivoRepository.save(historicoMouse1);

		historicoAtivoRepository.save(historicoMouse2);
		
		historicoAtivoRepository.save(historicoCabo1);
		
		historicoAtivoRepository.save(historicoCabo2);
		
		historicoAtivoRepository.save(historicoCabo3);

		/*
		 * Movimentacao movimentacaoBusca = new Movimentacao();
		 * 
		 * movimentacaoBusca = movimentacaoRepository.getById(1);
		 * 
		 * movimentacaoBusca.getListaGabinete();
		 */
		
	}

}
