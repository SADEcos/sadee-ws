package br.com.unicamp.mc437.configuration;

import br.com.unicamp.mc437.service.AccountService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "br.com.unicamp.mc437.controller " +
        "br.com.unicamp.mc437.dao " +
        "br.com.unicamp.mc437.service")
public class AppConfiguration {

    @Bean
    @Qualifier("accountService")
    public AccountService getAccountService() {
        return new AccountService();
    }
}
