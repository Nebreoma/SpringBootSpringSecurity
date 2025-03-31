package ru.netology.SpringBootSpringSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    protected UserDetailsService users() {
        UserDetails admin = User.builder()
                .username("admin")
                .password("admin")
                .authorities("read", "write")
                .build();
        UserDetails user1 = User.builder()
                .username("Vlad")
                .password("1234")
                .authorities("read")
                .build();
        UserDetails user2 = User.builder()
                .username("Katia")
                .password("cat")
                .authorities("write")
                .build();
        return new InMemoryUserDetailsManager(admin, user1, user2);
    }

    @Bean
    public SecurityFilterChain configure (HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests (authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/persons/by-city").permitAll()
                                .requestMatchers("/persons/age").hasAuthority("read")
                                .requestMatchers("/persons/by-fullname").hasAuthority("write")
                                .anyRequest().authenticated()
                )
        .formLogin(withDefaults());
        return http.build();
    }
}
