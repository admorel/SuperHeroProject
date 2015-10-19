package fr.univ_smb.isc.m2.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("fr.univ_smb.isc.m2.**")
public class Application extends SpringBootServletInitializer {


}