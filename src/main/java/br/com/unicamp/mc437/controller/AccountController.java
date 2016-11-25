package br.com.unicamp.mc437.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicamp.mc437.model.Account;
import br.com.unicamp.mc437.service.AccountService;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;
    
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void novo(@RequestBody Account account){
		accountService.cadastro(account);
		
	}
    
    
}
