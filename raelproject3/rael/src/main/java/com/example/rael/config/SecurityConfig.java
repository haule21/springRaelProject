package com.example.rael.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.rael.security.AuthFailureHandler;
import com.example.rael.security.AuthSuccessHandler;
import com.example.rael.security.CustomAuthenticationProvider;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@EnableWebSecurity
@Configuration
@Slf4j
public class SecurityConfig{
	
	private final AuthSuccessHandler authSuccessHandler;
	private final AuthFailureHandler authFailureHandler;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// configure SecurityFilterChain
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.mvcMatchers("/login").permitAll().
				anyRequest().authenticated();
		
		http
			.formLogin()
				.loginPage("/login").loginProcessingUrl("/loginProc").successHandler(authSuccessHandler).failureHandler(authFailureHandler)
				.usernameParameter("id").passwordParameter("pw");
		http	
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login");
		
		http
			.sessionManagement()
			.maximumSessions(1)
			.maxSessionsPreventsLogin(false)
			.expiredUrl("/login");

		return http.build();
	}
	
    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.setAuthoritiesByUsernameQuery("SELECT USER_ID, USER_AUTH FROM RAEL_USER WHERE USER_ID = ?");
        users.setUsersByUsernameQuery("SELECT USER_ID, USER_PASSWORD, 'TRUE' AS ENABLED FROM RAEL_USER WHERE USER_ID = ?");
        return users;
    }
    
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.withUsername("rael")
//            .password("{noop}haul2")
//            .roles("ADMIN")
//            .build();
//        return new InMemoryUserDetailsManager(user);
//    }
    
//    @Bean
//    public void authenticationManagerBuilder(AuthenticationManagerBuilder auth) {
//    	auth.authenticationProvider(customAuthenticationProvider);
//    }

}
