package br.com.unicamp.mc437.dao;

import br.com.unicamp.mc437.model.SessionToken;

import javax.persistence.Entity;

public interface SessionTokenDAO extends AbstractDAO {

	SessionToken get(String token);
	
}
