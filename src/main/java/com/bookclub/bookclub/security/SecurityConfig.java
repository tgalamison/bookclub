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

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth
                .inMemoryAuthentication()
                .withUser("user").password(encoder.encode("password")).roles("USER")
                .and()
                .withUser("terryg").password(encoder.encode("1234qwer")).roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .permitAll();
    }
}









