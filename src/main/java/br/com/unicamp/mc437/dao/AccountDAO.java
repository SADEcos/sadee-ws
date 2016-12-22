package br.com.unicamp.mc437.dao;


import br.com.unicamp.mc437.model.Account;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface AccountDAO extends AbstractDAO{

    Account getAccountById(Long id);

    Account getAccountByEmailAndPassword(String email, String password);

	List<Account> getAccounts();
}
