 package org.infi.EMPManagement.Config;

import org.infi.EMPManagement.Security.JwtAuthenticationEntryPoint;
import org.infi.EMPManagement.Security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration

public class SecurityConfig {

	public static final String[] PUBLIC_URLS = { "/apis/authenticate", "/v3/api-docs", "/v2/api-docs",
			"/swagger-resources/**", "/swagger-ui/**", "/webjars/**"

	};
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("Admin@123")).roles("ADMIN")
//				.and().withUser("user").password(passwordEncoder().encode("User@123")).roles("USER");
//	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(requests -> requests.antMatchers(HttpMethod.DELETE, "/apis/employees/**")
						.hasRole("ADMIN").antMatchers(PUBLIC_URLS).permitAll().antMatchers("/apis/projects/**")
						.hasRole("ADMIN").anyRequest().authenticated())
				.exceptionHandling(ex -> ex.authenticationEntryPoint(jwtAuthenticationEntryPoint))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf(csrf -> csrf.disable())
//
//				.authorizeRequests(requests -> requests.antMatchers(HttpMethod.DELETE, "/apis/employees/**")
//						.hasRole("ADMIN").requestMatchers("/apis/projects/**").hasRole("ADMIN").antMatchers(PUBLIC_URLS)
//						.permitAll().anyRequest().authenticated())
//				// .httpBasic()
//				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//				.exceptionHandling(handling -> handling.authenticationEntryPoint(jwtAuthenticationEntryPoint))
//				.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//	}

//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
}
