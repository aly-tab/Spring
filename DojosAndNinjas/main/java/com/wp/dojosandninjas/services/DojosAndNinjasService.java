package com.wp.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wp.dojosandninjas.models.Dojo;
import com.wp.dojosandninjas.models.Ninja;
import com.wp.dojosandninjas.repositories.DojoRepository;
import com.wp.dojosandninjas.repositories.NinjaRepository;


@Service
public class DojosAndNinjasService {
	private final DojoRepository dojoRepository;
	private final NinjaRepository ninjaRepository;
	
	public DojosAndNinjasService(DojoRepository dojosRepository, NinjaRepository ninjaRepository) {
		this.dojoRepository = dojosRepository;
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}
	
	public Dojo createDojo(Dojo d) {
		return dojoRepository.save(d);
	}
	
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
	
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}
	
	public Ninja createNinja(Ninja n) {
		return ninjaRepository.save(n);
	}
}
