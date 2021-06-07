package kira.formation.auth.demo.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
public class Utilisateur {

	@Id
	private String id;
	private String email;
	private String username;
	private String password; //chiffré
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
}
