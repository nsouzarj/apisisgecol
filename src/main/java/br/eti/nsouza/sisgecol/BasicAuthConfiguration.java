package br.eti.nsouza.sisgecol;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//@Configuration
//@EnableWebSecurity
public class BasicAuthConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource data;
    @Autowired
    private UsuarioServico ususervico;
    @Autowired
    private CustomAuthenticationProvider authProvider;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  
        auth.authenticationProvider(authProvider);
        auth.jdbcAuthentication().dataSource(data).passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery(
				"select emailprincipal as username, senha as password, ativo from usuario where emailprincipal=?")
		.authoritiesByUsernameQuery(
				"select emailprincipal as username, senha as password, ativo  from usuario where emailprincipal=?");
//  builder.userDetailsService(ususervico).passwordEncoder(new BCryptPasswordEncoder());
    }
 

	
	  
	
	
	
 
    @Override
    protected void configure(HttpSecurity http) 
      throws Exception {
        http.csrf().disable()
          .authorizeRequests()
          .antMatchers("/login").permitAll()
          .anyRequest()
          .authenticated()
          .and()
          .httpBasic();
        http.cors();
    }

}
