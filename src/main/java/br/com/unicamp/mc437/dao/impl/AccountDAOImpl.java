package br.com.unicamp.mc437.dao.impl;

import br.com.unicamp.mc437.configuration.HibernateConfiguration;
import br.com.unicamp.mc437.dao.AccountDAO;
import br.com.unicamp.mc437.model.Account;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();

    public Criteria buildQuery() {
        Session session = sessionFactory.openSession();
        session.setCacheMode(CacheMode.IGNORE);
        return session.createCriteria(getClass());
    }

    @Override
    public Account getAccountById(Long id) {
        return null;
    }

    @Override
    public Account getAccountByEmailAndPassword(String email, String password) {
        Criteria query = buildQuery();
        query.add(Restrictions.eq("email", email));
        Account account = (Account) query.uniqueResult();
        return account;
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Account> getAccounts(){
    	Criteria query = buildQuery();
    	query.setProjection(Projections.property("name"))
    	.setProjection(Projections.property("id"))
    	.setProjection(Projections.property("email"))
    	.setProjection(Projections.property("busy"))
    	.setProjection(Projections.property("course"))
    	.setProjection(Projections.property("availability"))
    	.setProjection(Projections.property("university"))
    	.setProjection(Projections.property("knowledgeList"));

    	return query.list();
    }

    @Override
    public void saveOrUpdate(Object object) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().saveOrUpdate(object);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }
}
