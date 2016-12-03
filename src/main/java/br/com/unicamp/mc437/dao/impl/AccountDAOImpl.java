package br.com.unicamp.mc437.dao.impl;

import br.com.unicamp.mc437.configuration.HibernateConfiguration;
import br.com.unicamp.mc437.dao.AbstractDAO;
import br.com.unicamp.mc437.dao.AccountDAO;
import br.com.unicamp.mc437.jdbc.AccountRowMapper;
import br.com.unicamp.mc437.model.Account;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAOImpl extends AbstractDAO implements AccountDAO {

    @Autowired
    private HibernateConfiguration hibernateConfiguration;


    private Session session;

    private static final String SELECT_ACCOUNT_BY_ID_QUERY = "SELECT * FROM account WHERE account_id = :id";

    private static final String SELECT_ACCOUNT_BY_EMAIL_AND_PASSWORD = "SELECT * FROM account WHERE email = :email AND password = :password";

    private Criteria buildQuery() {
        session = hibernateConfiguration.getSessionFactory().openSession();
        return session.createCriteria(AccountDAO.class);
    }

    @Override
    public Account getAccountById(Long id) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        List<Account> accountList = new NamedParameterJdbcTemplate(this.getJdbcTemplate()).query(SELECT_ACCOUNT_BY_ID_QUERY,
                params, new AccountRowMapper());

        if (accountList == null || accountList.isEmpty()) {
            return null;
        }
        return accountList.get(0);
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
    public void criar(Account account) {
        session.saveOrUpdate(account);
    }
}
