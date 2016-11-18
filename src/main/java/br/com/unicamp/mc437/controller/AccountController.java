package br.com.unicamp.mc437.controller;

import br.com.unicamp.mc437.model.Account;
import br.com.unicamp.mc437.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public void setAccountService(final AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @RequestMapping(value = "/authenticate", produces={"application/json"}, method = RequestMethod.POST)
    public Account authenticate(@RequestBody Account account, HttpServletRequest request,
                                HttpServletResponse response) {
        final Account user = accountService.accountByEmailAndPassword(account.getEmail(), account.getPassword());

        request.getSession(true);
        return user;
    }
}
