package fr.univ_smb.isc.m2.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@ComponentScan("fr.univ_smb.isc.m2.**")
@Configuration
public class Application {


}