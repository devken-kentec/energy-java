package br.com.kentec.energy.dto;

public class UserMobileDTO {
	private String login;
	private Long id;
	
	public UserMobileDTO() {
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserMobileDTO [login=" + login + ", id=" + id + "]";
	}
}
