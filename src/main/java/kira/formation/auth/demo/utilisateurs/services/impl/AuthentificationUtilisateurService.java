package kira.formation.auth.demo.utilisateurs.services.impl;

import java.util.Optional;

import org.bson.internal.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import kira.formation.auth.demo.utilisateurs.dto.ConnexionDTO;
import kira.formation.auth.demo.utilisateurs.entities.Utilisateur;
import kira.formation.auth.demo.utilisateurs.repositories.UtilisateurRepository;
import kira.formation.auth.demo.utilisateurs.services.AuthentificationService;

public class AuthentificationUtilisateurService implements AuthentificationService{

	private UtilisateurRepository repository;
	
	public AuthentificationUtilisateurService(UtilisateurRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public String connexion(ConnexionDTO dto) {
		// Trouver l'utilisateur en fonction de l'username ou email
		Optional<Utilisateur> optional = this.repository.findFirstByUsernameOrEmail(
				dto.getUsernameOrEmail(), 
				dto.getUsernameOrEmail());
		Utilisateur utilisateur = optional.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		if (utilisateur.getPassword().equals(Base64.encode(dto.getPassword().getBytes())))
			return utilisateur.getId();
		throw new ResponseStatusException(HttpStatus.FORBIDDEN);
	}
}
