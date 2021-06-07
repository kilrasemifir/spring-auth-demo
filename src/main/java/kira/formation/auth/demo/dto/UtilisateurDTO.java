package kira.formation.auth.demo.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UtilisateurDTO {
	private String id;
	private String email;
	private String username;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	
}
