package kira.formation.auth.demo.services;

import java.util.List;

import kira.formation.auth.demo.dto.CreationUtilisateurDTO;
import kira.formation.auth.demo.dto.SimpleUtilisateurDTO;
import kira.formation.auth.demo.dto.UtilisateurDTO;

public interface UtilisateurService {

	public UtilisateurDTO creationNouveauUtilisateur(CreationUtilisateurDTO dto);
	public SimpleUtilisateurDTO findById(String id);
	public List<SimpleUtilisateurDTO> trouverToutLesUtilisateurs();
}
