package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
    @Autowired
    protected void configureUser(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("billy").password("{noop}bob").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("ADMIN");
    }

    // We do not want the default behavior of form authentication
    // before HTTP Basic authentication we get
    // from WebSecurityConfigurerAdapter.
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	                
	        		
	                .antMatchers("/xyz").permitAll()
	                .anyRequest().authenticated()
	              //  .antMatchers("/pqr").hasRole("ADMIN")
	                .and()
	                .formLogin();
	                
	        
	        
	                //.httpBasic()
	        
	        //for H2 DB
	        /*http.csrf().disable();
	        http.headers().frameOptions().disable();
	               */
	    }
	 
	 @Bean
	 public UserDetailsService userDetailsService()
	 {
		 
		 UserBuilder user = User.withDefaultPasswordEncoder();
		 
		 InMemoryUserDetailsManager manger = new InMemoryUserDetailsManager();
		 
		 manger.createUser(user.username("user").password("password").roles("USER").build());
		 manger.createUser(user.username("admin").password("password").roles("USER","ADMIN").build());
		 
		 
		return manger;
		 
	 }

	
	
}
