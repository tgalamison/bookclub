/*
		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
		    https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

        Dan Vega. (2022, August 26). Spring Security without the WebSecurityConfigurerAdapter.YouTube.
        https://www.youtube.com/watch?v=s4X4SJv2RrU

		Walls, C. (2019). Spring In Action (5th ed.). Shelter Island, NY: Manning Publications.
		    Modified by Terrence Galamison (2023)
*/

package com.bookclub.bookclub.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

// Annotation to mark this class as a configuration component in Spring.
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Creating a password encoder using Spring security's delegating password encoder.
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth
                .inMemoryAuthentication()
                .withUser("user").password(encoder.encode("password")).roles("USER")
                .and()
                .withUser("testuser01").password(encoder.encode("password01")).roles("USER", "ADMIN");

    }
    // Overriding the configure method from WebSecurityConfigurerAdapter for HTTP security setup.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/monthly-books/list", "/monthly-books/new", "/monthly-books").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                // Configures the form login with a custom login page.
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                // Sets logout process.
                .logout()
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .permitAll();
    }
}









