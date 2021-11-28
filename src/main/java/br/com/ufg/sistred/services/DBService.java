package br.com.ufg.sistred.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufg.sistred.domain.Gabinete;
import br.com.ufg.sistred.domain.HistoricoAtivo;
import br.com.ufg.sistred.domain.Mouse;
import br.com.ufg.sistred.domain.Movimentacao;
import br.com.ufg.sistred.domain.ResponsavelDepartamentoOrgao;
import br.com.ufg.sistred.domain.Usuario;
import br.com.ufg.sistred.repositories.GabineteRepository;
import br.com.ufg.sistred.repositories.HistoricoAtivoRepository;
import br.com.ufg.sistred.repositories.MouseRepository;
import br.com.ufg.sistred.repositories.MovimentacaoRepository;
import br.com.ufg.sistred.repositories.ResponsavelDepartamentoOrgaoRepository;
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
	private ResponsavelDepartamentoOrgaoRepository responsavelDepartamentoOrgaoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private HistoricoAtivoRepository historicoAtivoRepository;

	public void instanciaBancoDeDados() {

		Usuario usuario = new Usuario(null,"ericson","$2a$10$3wI9N2GiSmi2WSZ2FhNAAeWcwRwwHtAg2BG3wvZHfq2uHUprCVZBe");
		
		ResponsavelDepartamentoOrgao responsavelDepartamentoOrgao = 
		new ResponsavelDepartamentoOrgao(null,"Ericson","CERCOMP","CERCOMP","asdfasdfs",null);

		Gabinete gabinete1 = new Gabinete(null, "Novo", "I5", "8GB", "Windows", "1TB", "LAÇKLA-ÇALSKD-ÇLSKD","444444",
				null, null);
		Gabinete gabinete2 = new Gabinete(null, "Novo2", "I8", "8GB", "Windows7", "1TB", "LAÇKLA-asdfaasdf-ÇLSKD","98w4t3456234",
				null, null);
		
		Mouse mouse1 = new Mouse(null,"Novo","HP","HP","3234123421",null,null);          

		ArrayList<Gabinete> listaGabinete = new ArrayList<>();
		ArrayList<Gabinete> listaGabinete2 = new ArrayList<>();
		ArrayList<Mouse> listaMouse = new ArrayList<>();
		
		listaGabinete.add(gabinete1);
		listaGabinete.add(gabinete2);
		listaGabinete2.add(gabinete1);
		listaMouse.add(mouse1);
		
		
		//movimentacao.getGabinetes().addAll(Arrays.asList(gabinete));

		usuarioRepository.saveAll(Arrays.asList(usuario));
		gabineteRepository.saveAll(Arrays.asList(gabinete1));
		gabineteRepository.saveAll(Arrays.asList(gabinete2));
		mouseRepository.saveAll(Arrays.asList(mouse1));
		responsavelDepartamentoOrgaoRepository.saveAll(Arrays.asList(responsavelDepartamentoOrgao));
		
	/*	
	public Movimentacao(Integer id, String tipo, String origem, String destino, Timestamp data, String observacao,
			ResponsavelDepartamentoOrgao responsavelDepartamentoOrgao, List<Gabinete> listaGabinete,
			List<Mouse> listaMouse)*/
		
		Movimentacao movimentacao = new Movimentacao(null, "recolhimento", "DLOG", "CERCOMP", new Timestamp(0),"TSTE", 
				responsavelDepartamentoOrgao , listaGabinete,listaMouse);
		
		movimentacaoRepository.saveAll(Arrays.asList(movimentacao));
		
		/*Movimentacao movimentacao2 = new Movimentacao(null, "distribuicao", "DLOG","DCOM" ,new Timestamp(0),"TESTE", 
				responsavelDepartamentoOrgao,	listaGabinete2,null);
		
		movimentacaoRepository.saveAll(Arrays.asList(movimentacao2));*/
		

		HistoricoAtivo historicoGabinete1 = new HistoricoAtivo(null, "funcionando", new Timestamp(0), gabinete1, null,null);
		
		HistoricoAtivo historicoGabinete2 = new HistoricoAtivo(null, "apresentou desfeito", new Timestamp(0), gabinete2, null ,null);
		
		HistoricoAtivo historicoGabinete3 = new HistoricoAtivo(null, "apresentou desfeito", new Timestamp(0), null, mouse1,null);
		
		
		historicoAtivoRepository.save(historicoGabinete1);
		
		historicoAtivoRepository.save(historicoGabinete2);
		
		historicoAtivoRepository.save(historicoGabinete3);
		
		
		/*Movimentacao movimentacaoBusca = new Movimentacao();
		
	    movimentacaoBusca =	 movimentacaoRepository.getById(1);
	    
	    movimentacaoBusca.getListaGabinete();*/
		
		
		
		
		
	}

}
