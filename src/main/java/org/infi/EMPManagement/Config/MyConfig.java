package org.infi.EMPManagement.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
class MyConfig {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

    @Bean
    UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder().
                username("admin")
                .password(passwordEncoder.encode("Admin@123")).roles("ADMIN").
                build();
        UserDetails user2 = User.builder().
                username("user")
                .password(passwordEncoder.encode("User@123")).roles("USER").
                build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

    
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
