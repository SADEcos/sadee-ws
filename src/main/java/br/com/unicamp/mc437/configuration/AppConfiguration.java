package br.com.unicamp.mc437.configuration;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "br.com.unicamp.mc437.controller " +
        "br.com.unicamp.mc437.dao " +
        "br.com.unicamp.mc437.service")
public class AppConfiguration {

}
