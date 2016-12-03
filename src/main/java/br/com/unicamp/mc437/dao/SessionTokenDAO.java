package br.com.unicamp.mc437.dao;

import br.com.unicamp.mc437.model.SessionToken;

public interface SessionTokenDAO {

	void create(SessionToken session);
	
	SessionToken get(String token);
	
}
