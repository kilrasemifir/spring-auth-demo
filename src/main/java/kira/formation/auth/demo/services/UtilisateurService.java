package kira.formation.auth.demo.services;

import java.util.List;

import kira.formation.auth.demo.dto.ConnexionDTO;
import kira.formation.auth.demo.dto.CreationUtilisateurDTO;
import kira.formation.auth.demo.dto.ModificationUsernamePasswordDTO;
import kira.formation.auth.demo.dto.SimpleUtilisateurDTO;
import kira.formation.auth.demo.dto.UtilisateurDTO;
import kira.formation.auth.demo.models.Utilisateur;

public interface UtilisateurService {

	public UtilisateurDTO creationNouveauUtilisateur(CreationUtilisateurDTO dto);
	public SimpleUtilisateurDTO findSimpleUtilisateurById(String id);
	public List<SimpleUtilisateurDTO> trouverToutLesUtilisateurs();
	public void supprimerUtilisateur(String id);
	public UtilisateurDTO modificationUsernamePassword(ModificationUsernamePasswordDTO dto);
	public String connexion(ConnexionDTO dto);
	public Utilisateur findById(String id);
	public Utilisateur save(Utilisateur utilisateur);
}
