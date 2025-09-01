package beraterkul.birthdaywishesportal.configuration;

import beraterkul.birthdaywishesportal.service.SecurityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig {

    private final SecurityService securityService;
    private final AuthenticationSuccessHandler authSuccessHandler; //Role base Authentication

    public SecurityConfig(SecurityService securityService, AuthenticationSuccessHandler authSuccessHandler) {
        this.securityService = securityService;
        this.authSuccessHandler = authSuccessHandler;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/user/create").hasAuthority("Admin")
                        .requestMatchers("/user/list").hasAuthority("Admin")
                        .requestMatchers("/user/update/**").hasAuthority("Admin")
                        .requestMatchers("/user/delete/**").hasAuthority("Admin")
                        .requestMatchers("/message/list").hasAuthority("Admin")

                        .requestMatchers("/message/list").hasAuthority("Teacher")
                        .requestMatchers("/message/last").hasAuthority("Teacher")
                        .requestMatchers("/message/reply").hasAuthority("Teacher")
                        .requestMatchers("/message/reply/**").hasAuthority("Teacher")

                        .requestMatchers("/message/create/").hasAuthority("Student")
                        .requestMatchers("/message/send").hasAuthority("Student")
                        .requestMatchers("/message/list/**").hasAuthority("Student")
                        .requestMatchers("/message/list/**").hasAuthority("Student")
                        // .requestMatchers("/message/delete/**").hasAuthority("Student")

                        .requestMatchers(
                                "/",
                                "/login",
                                "/fragments/**",
                                "/assets/**",
                                "/images/**"
                        ).permitAll()

                        .anyRequest().authenticated())

//              .httpBasic(Customizer.withDefaults())

                .formLogin(form -> form
                        .loginPage("/login")
                        .usernameParameter("email") // email parametresini kullan
                        .passwordParameter("password")
                        .successHandler(authSuccessHandler)
                        .failureUrl("/login?error=true")
                        .permitAll())

                .logout(logout -> logout
                        .logoutSuccessUrl("/login")
                        .logoutUrl("/logout")
                        .permitAll())

                .rememberMe(remember -> remember

                        .tokenValiditySeconds(120)
                        .key("cydeo")
                        .userDetailsService(securityService))

                .build();

    }

}