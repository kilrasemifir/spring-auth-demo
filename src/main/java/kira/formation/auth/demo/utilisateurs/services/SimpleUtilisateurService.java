package kira.formation.auth.demo.utilisateurs.services;

import java.util.List;

import kira.formation.auth.demo.utilisateurs.dto.SimpleUtilisateurDTO;

public interface SimpleUtilisateurService {

	SimpleUtilisateurDTO findSimpleUtilisateurById(String id);

	List<SimpleUtilisateurDTO> trouverToutLesUtilisateurs();

}