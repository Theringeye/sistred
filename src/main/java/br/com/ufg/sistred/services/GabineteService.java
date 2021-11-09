package br.com.ufg.sistred.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufg.sistred.domain.Gabinete;
import br.com.ufg.sistred.repositories.GabineteRepository;

@Service
public class GabineteService {

	@Autowired
	private GabineteRepository gabineteRepository;

	public Gabinete findById(Integer id) {

		Optional<Gabinete> obj = gabineteRepository.findById(id);
		return obj.orElse(null);

	}

	public Gabinete save(Gabinete gabinete) {

		gabineteRepository.save(gabinete);
		return gabinete;

	}

}
