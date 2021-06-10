package kira.formation.auth.demo.utilisateurs.services.impl;

import java.time.LocalDateTime;

import org.bson.internal.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;

import kira.formation.auth.demo.utilisateurs.dto.CreationUtilisateurDTO;
import kira.formation.auth.demo.utilisateurs.dto.ModificationUsernamePasswordDTO;
import kira.formation.auth.demo.utilisateurs.dto.UtilisateurDTO;
import kira.formation.auth.demo.utilisateurs.entities.Utilisateur;
import kira.formation.auth.demo.utilisateurs.repositories.UtilisateurRepository;
import kira.formation.auth.demo.utilisateurs.services.ModificationUtilisateurService;
import kira.formation.auth.demo.utilisateurs.services.UtilisateurService;

public class ModificationUtilisateurServiceImpl implements ModificationUtilisateurService{

	private ObjectMapper mapper;
	private UtilisateurRepository repository;
	private UtilisateurService service;
	
	public ModificationUtilisateurServiceImpl(ObjectMapper mapper, UtilisateurRepository repository,
			UtilisateurService service) {
		super();
		this.mapper = mapper;
		this.repository = repository;
		this.service = service;
	}

	@Override
	public UtilisateurDTO creationNouveauUtilisateur(CreationUtilisateurDTO dto) {
		checkCreationUtilisateur(dto);
		Utilisateur entity = this.mapper.convertValue(dto, Utilisateur.class);
		entity.setPassword(Base64.encode(dto.getPassword().getBytes()));
		entity.setCreateAt(LocalDateTime.now());
		entity.setUpdateAt(LocalDateTime.now());
		Utilisateur result = this.repository.save(entity);
		return this.mapper.convertValue(result, UtilisateurDTO.class);
	}
	
	private void checkCreationUtilisateur(CreationUtilisateurDTO dto) {
		if (dto.getEmail()==null || dto.getUsername()==null || dto.getPassword()==null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public UtilisateurDTO modificationUsernamePassword(ModificationUsernamePasswordDTO dto) {
		Utilisateur utilisateur = this.service.findById(dto.getId());
		if(dto.getUsername()!=null)
			utilisateur.setUsername(dto.getUsername());
		if(dto.getEmail() != null)
			utilisateur.setEmail(dto.getEmail());
		Utilisateur result = this.repository.save(utilisateur);
		return this.mapper.convertValue(result, UtilisateurDTO.class);
	}

}
