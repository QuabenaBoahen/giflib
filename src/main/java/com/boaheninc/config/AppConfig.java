package com.boaheninc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.boaheninc.*")
public class AppConfig {
  public static void main (String[] args){
	  SpringApplication.run(AppConfig.class, args);
  }
}
