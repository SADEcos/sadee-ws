package br.com.unicamp.mc437.service;

import br.com.unicamp.mc437.dao.AccountDAO;
import br.com.unicamp.mc437.exception.AccountException;
import br.com.unicamp.mc437.exception.GeneralServiceErrorException;
import br.com.unicamp.mc437.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {

    private AccountDAO accountDAO;

    @Autowired
    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Account login(final Account account) throws GeneralServiceErrorException{
        if (account.getEmail() == null) {
            throw new AccountException();
        }
        // TODO
        return null;
    }

    public Account getAccountById(Long id) {
        return accountDAO.getAccountById(id);
    }
}
