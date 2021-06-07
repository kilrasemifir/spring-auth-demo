package kira.formation.auth.demo.services.impl;

import java.time.LocalDateTime;

import org.bson.internal.Base64;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import kira.formation.auth.demo.dto.CreationUtilisateurDTO;
import kira.formation.auth.demo.dto.UtilisateurDTO;
import kira.formation.auth.demo.models.Utilisateur;
import kira.formation.auth.demo.repositorories.UtilisateurRepository;
import kira.formation.auth.demo.services.UtilisateurService;

public class UtilisateurServiceImpl implements UtilisateurService{

	private ObjectMapper mapper = new ObjectMapper();
	
	private UtilisateurRepository repository;
	
	public UtilisateurServiceImpl(UtilisateurRepository repository) {
		this.repository = repository;
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
	}
	
	@Override
	public UtilisateurDTO creationNouveauUtilisateur(CreationUtilisateurDTO dto) {
		Utilisateur entity = this.mapper.convertValue(dto, Utilisateur.class);
		System.out.println(dto);
		entity.setPassword(Base64.encode(dto.getPassword().getBytes()));
		entity.setCreateAt(LocalDateTime.now());
		entity.setUpdateAt(LocalDateTime.now());
		Utilisateur result = this.repository.save(entity);
		return this.mapper.convertValue(result, UtilisateurDTO.class);
	}

}
