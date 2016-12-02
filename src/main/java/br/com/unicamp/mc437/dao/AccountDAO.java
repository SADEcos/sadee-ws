package br.com.unicamp.mc437.dao;


import br.com.unicamp.mc437.model.Account;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface AccountDAO {

    Account getAccountById(Long id);

    void criar(Account account);

    Account getAccountByEmailAndPassword(String email, String password);

	List<Account> getAccounts();
}
