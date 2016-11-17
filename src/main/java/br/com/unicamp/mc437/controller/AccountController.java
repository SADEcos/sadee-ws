package br.com.unicamp.mc437.controller;

import br.com.unicamp.mc437.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
}
