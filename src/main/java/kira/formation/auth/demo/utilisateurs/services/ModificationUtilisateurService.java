package kira.formation.auth.demo.utilisateurs.services;

import kira.formation.auth.demo.utilisateurs.dto.CreationUtilisateurDTO;
import kira.formation.auth.demo.utilisateurs.dto.ModificationUsernamePasswordDTO;
import kira.formation.auth.demo.utilisateurs.dto.UtilisateurDTO;

public interface ModificationUtilisateurService {

	UtilisateurDTO creationNouveauUtilisateur(CreationUtilisateurDTO dto);

	UtilisateurDTO modificationUsernamePassword(ModificationUsernamePasswordDTO dto);

}