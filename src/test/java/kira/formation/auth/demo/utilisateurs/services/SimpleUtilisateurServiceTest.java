package kira.formation.auth.demo.utilisateurs.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import kira.formation.auth.demo.utilisateurs.dto.SimpleUtilisateurDTO;
import kira.formation.auth.demo.utilisateurs.entities.Utilisateur;
import kira.formation.auth.demo.utilisateurs.repositories.FakeUtilisateurRepository;
import kira.formation.auth.demo.utilisateurs.services.impl.SimpleUtilisateurServiceImpl;

public class SimpleUtilisateurServiceTest {

	static FakeUtilisateurRepository repository = new FakeUtilisateurRepository();
	static SimpleUtilisateurService service = 
			new SimpleUtilisateurServiceImpl(new ObjectMapper(), repository);
	
	public void test_findAll() {
		repository.save(new Utilisateur());
		repository.save(new Utilisateur());
		repository.save(new Utilisateur());
		repository.save(new Utilisateur());
		repository.save(new Utilisateur());
		List<SimpleUtilisateurDTO> result = service.trouverToutLesUtilisateurs();
		assertEquals(5, result.size());
	}
}
