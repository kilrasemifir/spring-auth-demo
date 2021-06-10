package kira.formation.auth.demo.utilisateurs.services;

import kira.formation.auth.demo.utilisateurs.dto.ConnexionDTO;

public interface AuthentificationService {

	String connexion(ConnexionDTO dto);

}