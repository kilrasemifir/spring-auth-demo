package kira.formation.auth.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kira.formation.auth.demo.dto.CreationUtilisateurDTO;
import kira.formation.auth.demo.dto.UtilisateurDTO;
import kira.formation.auth.demo.services.UtilisateurService;

@CrossOrigin
@RestController
@RequestMapping("utilisateurs")
public class UtilisateurController {

	@Autowired
	private UtilisateurService service;
	
	@PostMapping("")
	public UtilisateurDTO creationNouveauUtilisateur(@RequestBody CreationUtilisateurDTO dto) {
		return this.service.creationNouveauUtilisateur(dto);
	}
}
