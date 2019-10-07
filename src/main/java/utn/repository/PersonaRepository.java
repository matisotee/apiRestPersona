package utn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import utn.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer>{
	//preguntar porque puedo llamar a sus medotos siendo interfaz
}
