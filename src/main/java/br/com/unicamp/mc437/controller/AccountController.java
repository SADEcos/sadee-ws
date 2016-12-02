package br.com.unicamp.mc437.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.unicamp.mc437.model.Account;
import br.com.unicamp.mc437.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    public void setAccountService(final AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void novo(@RequestBody Account account) {
        if (null != account) {
            accountService.cadastro(account);
        }
    }

    @RequestMapping(value = "/teste/{}", method = RequestMethod.POST)
    public void teste(@RequestBody String teste) {
        String t = teste;
        return;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @RequestMapping(value = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Account> authenticate(@RequestBody Account account, HttpServletRequest request) {
        final Account user = accountService.accountByEmailAndPassword(account.getEmail(), account.getPassword());

        request.getSession(true);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
