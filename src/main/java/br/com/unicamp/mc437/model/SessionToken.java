package br.com.unicamp.mc437.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "TOKEN")
public class SessionToken extends Base {
	
	@SuppressWarnings("deprecation")
	public SessionToken(String token, Date date, Date expirationDate) {
		this.token = token;
		this.setCreateDate(date);
		this.expirationDate = expirationDate.getMinutes();
	}
	
	@Column(name = "TOKEN", nullable = false)
	private String token;
	@Column(name = "EXPIRATION_DATE", nullable = false)
	private int expirationDate;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(int expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
}
