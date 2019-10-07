package utn.service;


import org.springframework.stereotype.Service;

import utn.DTO.PersonaDTO;
import utn.entity.Persona;
import utn.repository.PersonaRepository;

@Service
public class PersonaService extends BaseService<Persona, PersonaDTO>{

	private PersonaRepository personaRepository;	
	
	public PersonaService(PersonaRepository repository) {
		super(repository, PersonaDTO.class, Persona.class);
		this.personaRepository = repository;
	}

}
