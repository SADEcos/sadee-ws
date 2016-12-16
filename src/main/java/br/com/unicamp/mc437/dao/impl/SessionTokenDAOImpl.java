package br.com.unicamp.mc437.dao.impl;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.unicamp.mc437.configuration.HibernateConfiguration;
import br.com.unicamp.mc437.dao.AbstractDAO;
import br.com.unicamp.mc437.dao.AccountDAO;
import br.com.unicamp.mc437.dao.SessionTokenDAO;
import br.com.unicamp.mc437.model.SessionToken;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public class SessionTokenDAOImpl extends AbstractDAO implements SessionTokenDAO {

	@Autowired
    private HibernateConfiguration hibernateConfiguration;
	
	private Session session;
	
	private Criteria buildQuery() {
        session = hibernateConfiguration.getSessionFactory().openSession();
        return session.createCriteria(SessionTokenDAO.class);
    }
	
	@Override
	public void create(SessionToken token) {
		session.saveOrUpdate(token);
	}

	@SuppressWarnings("deprecation")
	@Override
	public SessionToken get(String token) {
		Criteria query = buildQuery();
		Date date = new Date();
		query.add(Restrictions.eq("token", token));
		query.add(Restrictions.sizeGe("expirationDate", date.getMinutes()));
		return (SessionToken) query.uniqueResult();
	}
	
	
}
