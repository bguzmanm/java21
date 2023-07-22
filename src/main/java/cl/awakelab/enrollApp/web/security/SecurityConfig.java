package cl.awakelab.enrollApp.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public InMemoryUserDetailsManager userDetailsManager(PasswordEncoder encoder){
    UserDetails user = User.withUsername("user")
            .password(encoder.encode("kupita"))
            .roles("USER")
            .build();
    UserDetails admin = User.withUsername("admin")
            .password(encoder.encode("kupita"))
            .roles("USER", "ADMIN")
            .build();

    System.out.println(encoder.encode("kupita"));

    return new InMemoryUserDetailsManager(user, admin);
  }
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    http
            .authorizeRequests()
            /*.requestMatchers("/js/**", "/css/**", "/img/**").permitAll()*/
            /*.requestMatchers("/").permitAll()*/
            .requestMatchers("/student").hasAnyRole("USER", "ADMIN")
            .requestMatchers("/register").hasRole("ADMIN")
            .requestMatchers("/api/teacher").hasRole("ADMIN")
            .and()
            .httpBasic(Customizer.withDefaults())
            .formLogin()
            .loginPage("/login")
            /*.defaultSuccessUrl("/", true)*/
            .permitAll()
            .and()
            .logout().permitAll();

    return http.build();
  }

  @Bean
  public PasswordEncoder encoder(){
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    /*return new BCryptPasswordEncoder();*/
  }
}
