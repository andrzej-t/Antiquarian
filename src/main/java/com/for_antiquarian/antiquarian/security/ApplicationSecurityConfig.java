package com.for_antiquarian.antiquarian.security;

import com.for_antiquarian.antiquarian.auth.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, ApplicationUserService applicationUserService) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .anyRequest()
                .authenticated()
                .and()
//                .httpBasic()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/mainView", true) //redirecting
                .passwordParameter("password")
                .usernameParameter("username")
                .and()
                .rememberMe() //defaults to 2 weeks
                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(7)) // customizing remember me
                .key("sthVerySecured") // customizing remember me
                .rememberMeParameter("remember-me")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")) // if csrf enabled use PUT method for login out and remove this line
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login");


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }

//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//
//        UserDetails user1 = User.builder()
//                .username("Jan Kowalski")
//                .password(passwordEncoder().encode("password1"))
//                .authorities(READER.getGrantedAuthorities())
//                .build();
//
//        UserDetails user2 = User.builder()
//                .username("Adam Nowak")
//                .password(passwordEncoder().encode("password2"))
//                .authorities(LIBRARIAN.getGrantedAuthorities())
//                .build();
//
//        UserDetails user3 = User.builder()
//                .username("Katarzyna Nowacka")
//                .password(passwordEncoder().encode("password3"))
//                .authorities(ADMIN.getGrantedAuthorities())
//                .build();
//
//        return new InMemoryUserDetailsManager(
//                user1,
//                user2,
//                user3
//        );
//    }

}

