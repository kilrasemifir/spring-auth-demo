package kira.formation.auth.demo.utilisateurs.services.impl;

import java.util.Optional;

import org.bson.internal.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import kira.formation.auth.demo.utilisateurs.dto.ConnexionDTO;
import kira.formation.auth.demo.utilisateurs.entities.Utilisateur;
import kira.formation.auth.demo.utilisateurs.repositories.UtilisateurRepository;
import kira.formation.auth.demo.utilisateurs.services.AuthentificationService;

public class AuthentificationUtilisateurService implements AuthentificationService{


	private final Logger LOGGER = LoggerFactory.getLogger(AuthentificationUtilisateurService.class);;
	
	private UtilisateurRepository repository;
	
	public AuthentificationUtilisateurService(UtilisateurRepository repository) {
		this.repository = repository;
	}

	@Override
	public String connexion(ConnexionDTO dto) {
		Optional<Utilisateur> optional = this.repository.findFirstByUsernameOrEmail(
				dto.getUsernameOrEmail(), 
				dto.getUsernameOrEmail());
		Utilisateur utilisateur = optional.orElseThrow(()->{ 
			LOGGER.warn("L'utilisateur "+dto.getUsernameOrEmail()+ " n'existe pas");
			return new ResponseStatusException(HttpStatus.NOT_FOUND);
		});
		if (utilisateur.getPassword().equals(Base64.encode(dto.getPassword().getBytes())))
			return utilisateur.getId();
		LOGGER.warn("L'utilisateur "+utilisateur.getUsername()+" n'a pas entré le bon mot de passe");
		throw new ResponseStatusException(HttpStatus.FORBIDDEN);
	}
}
