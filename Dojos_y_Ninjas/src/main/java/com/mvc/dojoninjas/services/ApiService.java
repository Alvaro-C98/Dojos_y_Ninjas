package com.mvc.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mvc.dojoninjas.models.Dojos;
import com.mvc.dojoninjas.models.Ninjas;
import com.mvc.dojoninjas.repositories.DojoRepository;
import com.mvc.dojoninjas.repositories.NinjaRepository;

@Service 
public class ApiService {
	
	private final DojoRepository dojoRep;
	private final NinjaRepository ninjaRep;

	public ApiService(DojoRepository dojo,NinjaRepository ninja) {
		this.dojoRep=dojo;
		this.ninjaRep=ninja;
	}
	
	public List<Dojos> allDojos() {
		return dojoRep.findAll();
	}

	public Dojos createDojo(Dojos d) {
		return dojoRep.save(d);
	}
	
	public List<Ninjas> allNinjas() {
		return ninjaRep.findAll();
	}
	
	public Ninjas createNinja(Ninjas n) {
		return ninjaRep.save(n);
	}
	
}
