package kira.formation.auth.demo.utilisateurs.controllers;

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
	
	@Autowired
	private AuthentificationService authService;
	
	@PostMapping("connexion")
	public String connexion(@RequestBody ConnexionDTO dto) {
		return this.authService.connexion(dto);
	}
}
