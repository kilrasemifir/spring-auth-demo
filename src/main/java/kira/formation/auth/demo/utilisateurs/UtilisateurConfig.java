package kira.formation.auth.demo.utilisateurs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import kira.formation.auth.demo.logging.LoggerFactory;
import kira.formation.auth.demo.utilisateurs.repositories.UtilisateurRepository;
import kira.formation.auth.demo.utilisateurs.services.AuthentificationService;
import kira.formation.auth.demo.utilisateurs.services.SimpleUtilisateurService;
import kira.formation.auth.demo.utilisateurs.services.UtilisateurCRUDService;
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
	public AuthentificationService authService(UtilisateurRepository repository, LoggerFactory factory) {
		return new AuthentificationUtilisateurService(repository, factory);
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
