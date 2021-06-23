package kira.formation.auth.demo.utilisateurs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import kira.formation.auth.demo.utilisateurs.repositories.UtilisateurRepository;
import kira.formation.auth.demo.utilisateurs.services.AuthentificationService;
import kira.formation.auth.demo.utilisateurs.services.SimpleUtilisateurService;
import kira.formation.auth.demo.utilisateurs.services.UtilisateurService;
import kira.formation.auth.demo.utilisateurs.services.impl.AuthentificationUtilisateurService;
import kira.formation.auth.demo.utilisateurs.services.impl.ModificationUtilisateurServiceImpl;
import kira.formation.auth.demo.utilisateurs.services.impl.SimpleUtilisateurServiceImpl;
import kira.formation.auth.demo.utilisateurs.services.impl.UtilisateurServiceImpl;

/**
 * Configuration des services et autres elements pour les utilisateurs.
 * 
 * @author Killian
 *
 */
@Configuration
public class UtilisateurConfig {

	@Bean
	public UtilisateurService utilisateurService(UtilisateurRepository repository, ObjectMapper mapper) {
		return new UtilisateurServiceImpl(repository, mapper);
	}
	
	@Bean
	public AuthentificationService authService(UtilisateurRepository repository) {
		return new AuthentificationUtilisateurService(repository);
	}
	
	@Bean
	public ModificationUtilisateurServiceImpl modificationUtilisateurServiceImpl(
			ObjectMapper mapper, 
			UtilisateurRepository repository, UtilisateurService service) {
		return new ModificationUtilisateurServiceImpl(mapper, repository, service);
	}
	
	@Bean
	public SimpleUtilisateurService SimpleUtilisateurService(ObjectMapper mapper, UtilisateurRepository repository) {
		return new SimpleUtilisateurServiceImpl(mapper, repository);
	}
	
}
