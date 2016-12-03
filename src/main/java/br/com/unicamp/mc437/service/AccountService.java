package br.com.unicamp.mc437.service;

import br.com.unicamp.mc437.authentication.TokenGenerator;
import br.com.unicamp.mc437.dao.AccountDAO;
import br.com.unicamp.mc437.dao.SessionTokenDAO;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.assertj.core.util.DateUtil;
import org.mindrot.jbcrypt.BCrypt;

import br.com.unicamp.mc437.model.Account;
import br.com.unicamp.mc437.model.LoginDTO;
import br.com.unicamp.mc437.model.SessionToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    @Autowired
    private AccountDAO accountDAO;
    
    @Autowired
    private SessionTokenDAO sessionTokenDAO;

    @Transactional
    public List<Account> accounts(){
    	return accountDAO.getAccounts();
    }
    
    @Transactional
    public Account accountById(final String id){
    	return accountDAO.getAccountById(Long.parseLong(id));
    }
    
    @Transactional
    public LoginDTO authenticate(final String email, final String password) {
        final Account user = accountDAO.getAccountByEmailAndPassword(email, password);
        if(user != null){
        	String token = TokenGenerator.newSessionId();
        	Calendar calendar = Calendar.getInstance();
        	Date date = calendar.getTime();
        	calendar.add(Calendar.HOUR, 2);
        	Date expirationDate = calendar.getTime();
        	
        	SessionToken session = new SessionToken(token, date, expirationDate);
        	sessionTokenDAO.create(session);
        	
        	return new LoginDTO(user, token);
        }
        return null;
    }

    @Transactional
    public void cadastro(Account account) {
        String hashedPwd = BCrypt.hashpw(account.getPassword(), BCrypt.gensalt());
        account.setPassword(hashedPwd);
        accountDAO.criar(account);
    }
    
}
