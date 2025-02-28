package com.G1_Minde_agenci.configuration;

import com.G1_Minde_agenci.services.CustomerUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    /**
     * Custom UserDetailsService Bean
     */
    @Bean
    public org.springframework.security.core.userdetails.UserDetailsService userDetailsService() {
        return new CustomerUserDetailsService();
    }

    /**
     * Password Encoder Bean
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Authentication Provider Bean
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    /**
     * Security Filter Chain Configuration
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(withDefaults())  // Important to enable CORS support
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/users/**").permitAll()  // Public access for /users route
                        .anyRequest().authenticated()             // All other routes require authentication
                )
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .httpBasic(withDefaults());

        return http.build();
    }

    /**
     * CORS Configuration Source
     */

   // @Bean
   // public CorsConfigurationSource corsConfigurationSource() {
    //    CorsConfiguration configuration = new CorsConfiguration();
    //    configuration.setAllowedOrigins(List.of("https://g1-minde.netlify.app","http://127.0.0.1:5501" )); // Allowed origin for frontend
    //    configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Allow specific HTTP methods
    //    configuration.setAllowedHeaders(List.of("*")); // Allow all headers
   //     configuration.setAllowCredentials(true);

     //   UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //    source.registerCorsConfiguration("/**", configuration);
     //   return source;
   // }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of(
                "https://g1-minde.netlify.app",
                "http://127.0.0.1:5501",
                "128.199.195.156",
                "216.144.250.150",
                "69.162.124.226",
                "69.162.124.227",
                "69.162.124.228",
                "69.162.124.229",
                "69.162.124.230",
                "69.162.124.231",
                "69.162.124.232",
                "69.162.124.233",
                "69.162.124.234",
                "69.162.124.235",
                "69.162.124.236",
                "69.162.124.237",
                "69.162.124.238",
                "63.143.42.242",
                "63.143.42.243",
                "63.143.42.244",
                "63.143.42.245",
                "63.143.42.246",
                "63.143.42.247",
                "63.143.42.248",
                "63.143.42.249",
                "63.143.42.250",
                "63.143.42.251",
                "63.143.42.252",
                "63.143.42.253",
                "216.245.221.82",
                "216.245.221.83",
                "216.245.221.84",
                "216.245.221.85",
                "216.245.221.86",
                "216.245.221.87",
                "216.245.221.88",
                "216.245.221.89",
                "216.245.221.90",
                "216.245.221.91",
                "216.245.221.92",
                "216.245.221.93"
                // Tumhe yeh list puri karni padegi, sabhi Uptime Robot IPs ke saath
        ));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


}
