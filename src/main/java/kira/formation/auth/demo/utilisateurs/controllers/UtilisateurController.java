package kira.formation.auth.demo.utilisateurs.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kira.formation.auth.demo.utilisateurs.dto.CreationUtilisateurDTO;
import kira.formation.auth.demo.utilisateurs.dto.ModificationUsernamePasswordDTO;
import kira.formation.auth.demo.utilisateurs.dto.SimpleUtilisateurDTO;
import kira.formation.auth.demo.utilisateurs.dto.UtilisateurDTO;
import kira.formation.auth.demo.utilisateurs.entities.Utilisateur;
import kira.formation.auth.demo.utilisateurs.services.ModificationUtilisateurService;
import kira.formation.auth.demo.utilisateurs.services.SimpleUtilisateurService;
import kira.formation.auth.demo.utilisateurs.services.UtilisateurService;

@CrossOrigin
@RestController
@RequestMapping("utilisateurs")
public class UtilisateurController {

	private final Logger LOGGER = LoggerFactory.getLogger(UtilisateurController.class);
	
	@Autowired
	private UtilisateurService service;
	
	
	@Autowired
	private SimpleUtilisateurService simpleUtilisateurService;
	
	@Autowired
	private ModificationUtilisateurService modificationService;
	
	public UtilisateurController() {
		LOGGER.trace("Creation du controller pour les utilisateurs");
	}
	
	@PostMapping("")
	public UtilisateurDTO creationNouveauUtilisateur(@RequestBody CreationUtilisateurDTO dto) {
		LOGGER.info("Creation de l'utilisateur "+dto.getUsername());
		return this.modificationService.creationNouveauUtilisateur(dto);
	}
	
	@GetMapping("{id}/detail")
	public Utilisateur findByIdDetail(@PathVariable String id) {
		LOGGER.info("Recuperation des detail de lutilisateur d'id  "+id);
		return this.service.findById(id);
	}
	
	@GetMapping("{id}")
	public SimpleUtilisateurDTO findById(@PathVariable String id) {
		LOGGER.info("Recuperation de l'utilisateur d'id "+id);
		return this.simpleUtilisateurService.findSimpleUtilisateurById(id);
	}
	
	@GetMapping("")
	public List<SimpleUtilisateurDTO> findAll(){
		LOGGER.info("Recuperation de l'ensemble des utilisateurs");
		return this.simpleUtilisateurService.trouverToutLesUtilisateurs();
	}
	
	@DeleteMapping("{id}")
	public void supprimerParId(@PathVariable String id) {
		LOGGER.warn("Suppression de l'utilisateur d'id "+id);
		this.service.deleteById(id);
	}
	
	@PatchMapping("")
	public UtilisateurDTO modificationUserNamePassword(ModificationUsernamePasswordDTO dto) {
		LOGGER.info("Modification du mot de passe de l'utilisateur "+dto.getUsername());
		return this.modificationService.modificationUsernamePassword(dto);
	}
	
	
}
