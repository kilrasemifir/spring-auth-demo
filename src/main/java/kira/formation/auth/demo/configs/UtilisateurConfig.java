package kira.formation.auth.demo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import kira.formation.auth.demo.repositorories.UtilisateurRepository;
import kira.formation.auth.demo.services.UtilisateurService;
import kira.formation.auth.demo.services.impl.UtilisateurServiceImpl;

@Configuration
public class UtilisateurConfig {

	@Bean
	public UtilisateurService utilisateurService(UtilisateurRepository repository, ObjectMapper mapper) {
		return new UtilisateurServiceImpl(repository, mapper);
	}
	
	@Bean
	public ObjectMapper objectMapper() {
		/*return new ObjectMapper()
			.registerModule(new JavaTimeModule())
			.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
			.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
			.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
		*/
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
		return mapper;
	}
}
