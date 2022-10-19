package arc.ua.arcshop.configs;

import arc.ua.arcshop.services.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final AuthenticationSuccessHandler authenticationSuccessHandler;

    private final AccountServiceImpl accountService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler, AccountServiceImpl accountService, PasswordEncoder passwordEncoder) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(accountService)
                .passwordEncoder(passwordEncoder);
    }
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login.html", "/js/**", "/css/**", "/favicon.ico", "/logout", "/acc/**")
                    .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                    .httpBasic()
                .and()
                    .oauth2Login()
                    .loginPage("/login.html")
                    .successHandler(authenticationSuccessHandler)
                .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/");
    }

}

