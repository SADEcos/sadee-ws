package br.com.unicamp.mc437.model;

public class LoginDTO {
	private Account account;
	private String token;
	
	public LoginDTO(Account account, String token) {
		this.account = account;
		this.token = token;
	}
}
