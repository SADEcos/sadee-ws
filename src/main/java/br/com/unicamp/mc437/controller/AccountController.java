package br.com.unicamp.mc437.controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.unicamp.mc437.model.Account;
import br.com.unicamp.mc437.model.LoginDTO;
import br.com.unicamp.mc437.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    public void setAccountService(final AccountService accountService) {
        this.accountService = accountService;
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<List<Account> > searchDev(){
    	final List<Account> users = accountService.accounts();
    	
    	return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/dev/{id}", method = RequestMethod.GET)
    public ResponseEntity<Account> getDev(String id){
    	final Account user = accountService.accountById(id);

    	return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:1414")
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void signup(@RequestBody Account account) {
        if (null != account) {
            System.out.println(account.getUsername()+account.getCpf());
            accountService.cadastro(account);
        }
    }

    @RequestMapping(value = "/teste/{}", method = RequestMethod.GET)
    public void teste(@RequestBody String teste) {
        String t = teste;
        return;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @CrossOrigin(origins = "http://localhost:1414")
    @RequestMapping(value = "/signin", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<LoginDTO> authenticate(@RequestBody Account account, HttpServletRequest request) {
        final LoginDTO user = accountService.authenticate(account.getEmail(), account.getPassword());
        
        request.getSession(true);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
