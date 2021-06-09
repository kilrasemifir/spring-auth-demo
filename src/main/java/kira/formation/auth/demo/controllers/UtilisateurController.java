package kira.formation.auth.demo.controllers;

import java.util.List;

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

import kira.formation.auth.demo.dto.ConnexionDTO;
import kira.formation.auth.demo.dto.CreationUtilisateurDTO;
import kira.formation.auth.demo.dto.ModificationUsernamePasswordDTO;
import kira.formation.auth.demo.dto.SimpleUtilisateurDTO;
import kira.formation.auth.demo.dto.UtilisateurDTO;
import kira.formation.auth.demo.services.AuthentificationService;
import kira.formation.auth.demo.services.ModificationUtilisateurService;
import kira.formation.auth.demo.services.SimpleUtilisateurService;
import kira.formation.auth.demo.services.UtilisateurService;

@CrossOrigin
@RestController
@RequestMapping("utilisateurs")
public class UtilisateurController {

	@Autowired
	private UtilisateurService service;
	
	@Autowired
	private AuthentificationService authService;
	
	@Autowired
	private SimpleUtilisateurService simpleUtilisateurService;
	
	@Autowired
	private ModificationUtilisateurService modificationService;
	
	@PostMapping("")
	public UtilisateurDTO creationNouveauUtilisateur(@RequestBody CreationUtilisateurDTO dto) {
		return this.modificationService.creationNouveauUtilisateur(dto);
	}
	
	@GetMapping("{id}")
	public SimpleUtilisateurDTO findById(@PathVariable String id) {
		return this.simpleUtilisateurService.findSimpleUtilisateurById(id);
	}
	
	@GetMapping("")
	public List<SimpleUtilisateurDTO> findAll(){
		return this.simpleUtilisateurService.trouverToutLesUtilisateurs();
	}
	
	@DeleteMapping("{id}")
	public void supprimerParId(@PathVariable String id) {
		this.service.deleteById(id);
	}
	
	@PatchMapping("")
	public UtilisateurDTO modificationUserNamePassword(ModificationUsernamePasswordDTO dto) {
		return this.modificationService.modificationUsernamePassword(dto);
	}
	
	@PostMapping("connexion")
	public String connexion(@RequestBody ConnexionDTO dto) {
		return this.authService.connexion(dto);
	}
}
