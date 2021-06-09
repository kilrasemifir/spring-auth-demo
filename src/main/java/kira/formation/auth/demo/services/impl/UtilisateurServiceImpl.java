package kira.formation.auth.demo.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import kira.formation.auth.demo.models.Utilisateur;
import kira.formation.auth.demo.repositorories.UtilisateurRepository;
import kira.formation.auth.demo.services.UtilisateurService;

public class UtilisateurServiceImpl extends GenericCRUDServiceImpl<Utilisateur> implements UtilisateurService{

	public UtilisateurServiceImpl(UtilisateurRepository repository, ObjectMapper mapperParam) {
		super(repository);
	}

}
