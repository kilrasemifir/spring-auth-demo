package kira.formation.auth.demo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kira.formation.auth.demo.repositorories.UtilisateurRepository;
import kira.formation.auth.demo.services.UtilisateurService;
import kira.formation.auth.demo.services.impl.UtilisateurServiceImpl;

@Configuration
public class UtilisateurConfig {

	@Bean
	public UtilisateurService utilisateurService(UtilisateurRepository repository) {
		return new UtilisateurServiceImpl(repository);
	}
}
