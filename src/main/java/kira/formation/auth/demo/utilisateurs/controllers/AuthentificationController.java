package kira.formation.auth.demo.utilisateurs.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kira.formation.auth.demo.utilisateurs.dto.ConnexionDTO;
import kira.formation.auth.demo.utilisateurs.services.AuthentificationService;

@CrossOrigin
@RestController
@RequestMapping("auth")
public class AuthentificationController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(AuthentificationController.class);
	
	@Autowired
	private AuthentificationService authService;
	
	public AuthentificationController() {
		LOGGER.trace("Creation du controller d'authentification");
	}
	
	@PostMapping("connexion")
	public String connexion(@RequestBody ConnexionDTO dto) {
		LOGGER.info("Connexion de l'utilisateur "+dto.getUsernameOrEmail());
		return this.authService.connexion(dto);
	}
}
