package com.nhnacademy.projectbulk.config;

import com.nhnacademy.projectbulk.filter.SessionTimeResetFilter;
import com.nhnacademy.projectbulk.security.handler.LoginSuccessHandler;
import com.nhnacademy.projectbulk.security.service.LoginUserDetailsService;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.switchuser.SwitchUserFilter;
import org.springframework.security.web.firewall.StrictHttpFirewall;

/**
 * 스프링 시큐리티 설정
 *
 * @author 김민수
 * @since 1.0
 */
@Configuration
@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
public class SecurityConfig {
    public static final String loginUrl = "/login";
    public static final String logoutUrl = "/logout";
    private final LoginSuccessHandler loginSuccessHandler;
    private final LoginUserDetailsService loginUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin()
            .loginPage(loginUrl)
            .usernameParameter("id")
            .passwordParameter("password")
            .loginProcessingUrl(loginUrl)
            .failureUrl(loginUrl)
            .successHandler(loginSuccessHandler).and();

        http.authenticationProvider(authenticationProvider());

        http.oauth2Login()
            .loginPage(loginUrl)
            .failureUrl(loginUrl)
            .successHandler(loginSuccessHandler);

        http.logout()
            .deleteCookies("MY_SESSIONID")
            .clearAuthentication(true)
            .invalidateHttpSession(true)
            .logoutUrl(logoutUrl).and();

        http.headers()
                .xssProtection()
                    .xssProtectionEnabled(true)
                    .block(true).and()
                .frameOptions().deny().and();

        http.sessionManagement().sessionFixation(
            SessionManagementConfigurer.SessionFixationConfigurer::newSession)
            .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);

        http.addFilterAfter(getSessionTimeResetFilter(), SwitchUserFilter.class);

        return http.build();
    }

    private AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setPasswordEncoder(bcryptPasswordEncoder());
        authenticationProvider.setUserDetailsService(loginUserDetailsService);
        return authenticationProvider;
    }

    private PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2A);
    }

    private SessionTimeResetFilter getSessionTimeResetFilter() {
        return new SessionTimeResetFilter();
    }

    @Bean
    public StrictHttpFirewall httpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowedHttpMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "HEAD"));

        return firewall;
    }
}
