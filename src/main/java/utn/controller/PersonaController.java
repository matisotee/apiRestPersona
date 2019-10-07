package utn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import utn.DTO.PersonaDTO;
import utn.service.PersonaService;

@Controller
@RestController
@RequestMapping(path = "api/v1/persona")
public class PersonaController extends BaseController<PersonaDTO>{

	private PersonaService personaService;
	
	public PersonaController(PersonaService personaService) {
		super(personaService);
		this.personaService = personaService;
	}

}
