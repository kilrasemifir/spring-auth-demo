package kira.formation.auth.demo.services;

import kira.formation.auth.demo.dto.CreationUtilisateurDTO;
import kira.formation.auth.demo.dto.UtilisateurDTO;

public interface UtilisateurService {

	public UtilisateurDTO creationNouveauUtilisateur(CreationUtilisateurDTO dto);
}
