package kira.formation.auth.demo.services;

import kira.formation.auth.demo.dto.CreationUtilisateurDTO;
import kira.formation.auth.demo.dto.ModificationUsernamePasswordDTO;
import kira.formation.auth.demo.dto.UtilisateurDTO;

public interface ModificationUtilisateurService {

	UtilisateurDTO creationNouveauUtilisateur(CreationUtilisateurDTO dto);

	UtilisateurDTO modificationUsernamePassword(ModificationUsernamePasswordDTO dto);

}