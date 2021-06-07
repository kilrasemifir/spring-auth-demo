package kira.formation.auth.demo.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.internal.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;

import kira.formation.auth.demo.dto.ConnexionDTO;
import kira.formation.auth.demo.dto.CreationUtilisateurDTO;
import kira.formation.auth.demo.dto.ModificationUsernamePasswordDTO;
import kira.formation.auth.demo.dto.SimpleUtilisateurDTO;
import kira.formation.auth.demo.dto.UtilisateurDTO;
import kira.formation.auth.demo.models.Utilisateur;
import kira.formation.auth.demo.repositorories.UtilisateurRepository;
import kira.formation.auth.demo.services.UtilisateurService;

public class UtilisateurServiceImpl implements UtilisateurService{

	private ObjectMapper mapper;
	
	private UtilisateurRepository repository;
	
	public UtilisateurServiceImpl(UtilisateurRepository repository, ObjectMapper mapperParam) {
		this.repository = repository;
		this.mapper = mapperParam;
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
	
	public SimpleUtilisateurDTO findById(String id) {
		Utilisateur utilisateur = this.repository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
		return mapper.convertValue(utilisateur, SimpleUtilisateurDTO.class);
	}

	@Override
	public List<SimpleUtilisateurDTO> trouverToutLesUtilisateurs() {
		List<Utilisateur> utilisateurs = this.repository.findAll();
		/*
		return utilisateurs.stream().map(utilisateur->{
			return this.mapper.convertValue(utilisateur, SimpleUtilisateurDTO.class);
		}).collect(Collectors.toList());
		*/
		List<SimpleUtilisateurDTO> results = new ArrayList<>();
		for (Utilisateur utilisateur : utilisateurs) {
			results.add(this.mapper.convertValue(utilisateur, SimpleUtilisateurDTO.class));
		}
		return results;
	}

	@Override
	public void supprimerUtilisateur(String id) {
		if(this.repository.existsById(id))
			this.repository.deleteById(id);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	@Override
	public UtilisateurDTO modificationUsernamePassword(ModificationUsernamePasswordDTO dto) {
		Utilisateur utilisateur = this.repository.findById(dto.getId())
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
		if(dto.getUsername()!=null)
			utilisateur.setUsername(dto.getUsername());
		if(dto.getEmail() != null)
			utilisateur.setEmail(dto.getEmail());
		Utilisateur result = this.repository.save(utilisateur);
		return this.mapper.convertValue(result, UtilisateurDTO.class);
	}

	@Override
	public String connexion(ConnexionDTO dto) {
		// Trouver l'utilisateur en fonction de l'username ou email
		Optional<Utilisateur> optional = this.repository.findFirstByUsernameOrEmail(dto.getUsernameOrEmail(), dto.getUsernameOrEmail());
		Utilisateur utilisateur = optional.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		if (utilisateur.getPassword().equals(Base64.encode(dto.getPassword().getBytes())))
			return utilisateur.getId();
		throw new ResponseStatusException(HttpStatus.FORBIDDEN);
	}
	
	

}
