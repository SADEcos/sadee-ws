package br.com.unicamp.mc437.dao.impl;

import br.com.unicamp.mc437.dao.AccountDAO;
import br.com.unicamp.mc437.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public Account getAccountById(Long id) {
        return null;
    }
}
