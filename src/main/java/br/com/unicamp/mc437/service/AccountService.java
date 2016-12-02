package br.com.unicamp.mc437.service;

import br.com.unicamp.mc437.dao.AccountDAO;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import br.com.unicamp.mc437.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    @Autowired
    private AccountDAO accountDAO;

    @Transactional
    public List<Account> accounts(){
    	return accountDAO.getAccounts();
    }
    
    @Transactional
    public Account accountById(final String id){
    	return accountDAO.getAccountById(Long.parseLong(id));
    }
    
    @Transactional
    public Account accountByEmailAndPassword(final String email, final String password) {
        return accountDAO.getAccountByEmailAndPassword(email, password);
    }

    @Transactional
    public void cadastro(Account account) {
        String hashedPwd = BCrypt.hashpw(account.getPassword(), BCrypt.gensalt());
        account.setPassword(hashedPwd);
        accountDAO.criar(account);
    }
    
}
