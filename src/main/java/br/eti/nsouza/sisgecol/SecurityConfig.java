package br.eti.nsouza.sisgecol;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
//@CrossOrigin
@Configuration

@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)

//@ComponentScan(basePackages={"br.eti.nsouza.config","br.eti.nsouza.entidades","br.eti.nsouza.controle","br.eti.nsouza.repositorios","br.eti.nsouza.geral"})
//@Configuration

/**
 * Classe de segurança pra uso afins
 * 
 * @author Nelson
 *
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	

	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	BCryptPasswordEncoder encoder1 = new BCryptPasswordEncoder();

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		//http.csrf().disable().authorizeRequests().antMatchers("/login","/resources/**", "/webjars/**","/erro/**").permitAll().anyRequest().authenticated().and().httpBasic();
	
		
		
		 System.out.println("Logou....");
		  // http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	    
	    http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/login").permitAll()
				.antMatchers("/resources/**", "/webjars/**","/erro/**").permitAll().
				antMatchers("/uf/**","/tipos/**","/solicitacao/**", "/status/**", "/comarcapossui/**", "/usuarios/**","/colaborador/**", "/bancas/**", "/comarca/**").permitAll();
	     
		http.cors();
       	}
	



	@Autowired
	private DataSource data;

	@Override
	@Autowired
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		System.out.println("Entrei...." + data.getConnection());
        
		builder.jdbcAuthentication().dataSource(data).passwordEncoder(new BCryptPasswordEncoder())
				.usersByUsernameQuery(
						"select emailprincipal, senha as password, ativo from usuario where emailprincipal=?")
				.authoritiesByUsernameQuery(
						"select emailprincipal, senha as password, ativo  from usuario where emailprincipal=?");
		
	
		 // builder.inMemoryAuthentication()
		 // .withUser("tim").password("123").roles("ADMIN") .and()
		 // .withUser("nsouzarj@bol.com.br").password(encoder.encode("nso1810")).roles("USER");
		 
	}

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	


	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	public static void main(String[] args) {
		String password = "nso1810";
	    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();


		System.out.println(new BCryptPasswordEncoder().encode("nso1810"));
		
	}

}
