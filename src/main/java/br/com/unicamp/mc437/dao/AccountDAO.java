package br.com.unicamp.mc437.dao;


import br.com.unicamp.mc437.model.Account;

public interface AccountDAO {

    Account getAccountById(Long id);
    
    void criar(Account account);

}
