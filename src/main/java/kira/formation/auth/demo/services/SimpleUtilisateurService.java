package kira.formation.auth.demo.services;

import java.util.List;

import kira.formation.auth.demo.dto.SimpleUtilisateurDTO;

public interface SimpleUtilisateurService {

	SimpleUtilisateurDTO findSimpleUtilisateurById(String id);

	List<SimpleUtilisateurDTO> trouverToutLesUtilisateurs();

}