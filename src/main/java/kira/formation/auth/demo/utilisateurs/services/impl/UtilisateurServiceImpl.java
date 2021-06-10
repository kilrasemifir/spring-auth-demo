package kira.formation.auth.demo.utilisateurs.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import kira.formation.auth.demo.utilisateurs.entities.Utilisateur;
import kira.formation.auth.demo.utilisateurs.repositories.UtilisateurRepository;
import kira.formation.auth.demo.utilisateurs.services.UtilisateurService;

public class UtilisateurServiceImpl extends GenericCRUDServiceImpl<Utilisateur> implements UtilisateurService{

	public UtilisateurServiceImpl(UtilisateurRepository repository, ObjectMapper mapperParam) {
		super(repository);
	}

}
