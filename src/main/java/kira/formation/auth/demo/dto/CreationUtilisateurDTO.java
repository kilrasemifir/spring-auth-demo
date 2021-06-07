package kira.formation.auth.demo.dto;


public class CreationUtilisateurDTO {
	private String username;
	private String email;
	private String password;
	
	public String getPassword() {
		System.out.println(this);
		return this.password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CreationUtilisateurDTO [username=" + username + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
