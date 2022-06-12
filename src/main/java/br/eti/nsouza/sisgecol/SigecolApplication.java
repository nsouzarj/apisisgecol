package br.eti.nsouza.sisgecol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Meu primeiro restfull em spring Finalidade de estudo para integração com o
 * Angular o outro framework qualquer
 * 
 * @author Nelson
 *
 */

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
//@SpringBootApplication
@ComponentScan({ "br.eti.nsouza.controllers", "br.eti.nsouza.repositoris", "br.eti.nsouza.services",
		"br.eti.nsouza.sigecol", "br.eti.nsouza.utils" })
@EntityScan(basePackages = { "br.eti.nsouza.entities" })
public class SigecolApplication {
	public static void main(String[] args) {
		SpringApplication.run(SigecolApplication.class, args);
	}
}
