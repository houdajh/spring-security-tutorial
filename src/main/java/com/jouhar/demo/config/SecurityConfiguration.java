package com.jouhar.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**The AuthenticationManager is responsible for authenticating users and managing their authentication process.
  It is a core component in Spring Security that validates the credentials provided by the user and
  determines whether the user is authenticated or not.*/

/**In-memory user details, in the context of Spring Security, refers to a mechanism where user credentials
  and roles are stored in memory during runtime. It is a simple way to define and manage user authentication
  for small-scale applications or for testing and development purposes.*/

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.inMemoryAuthentication()
                .withUser("houda")
                .password("2001")
                .roles("USER");
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
        /**The NoOpPasswordEncoder is a deprecated implementation of the PasswordEncoder interface
        that does not perform any hashing or encoding of passwords.
        It is considered insecure and should not be used in production environments.(just for DEMO)*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER","ADMIN")
                .and().formLogin();
    }
}
