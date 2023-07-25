package cl.awakelab.enrollApp.web.security;

import cl.awakelab.enrollApp.model.persistence.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

/*  @Bean
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
  }*/

  UserRepository repository;

  public SecurityConfig(UserRepository repository) {
    this.repository = repository;
  }

  @Bean
  public UserDetailsService userDetailsService(){
    return new UserDetailsServiceImpl(repository);
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService());
    authProvider.setPasswordEncoder(encoder());
    return authProvider;
  }

  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authenticationProvider());
  }


  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    http
            .authorizeRequests()
            /*.requestMatchers("/js/**", "/css/**", "/img/**").permitAll()*/
            /*.requestMatchers("/").permitAll()*/
            .requestMatchers("/student").hasAuthority("USER")
            .requestMatchers("/register").hasAuthority("ADMIN")
            .requestMatchers("/api/teacher").hasAuthority("ADMIN")
            .requestMatchers("/api/teacher/**").hasAnyAuthority("ADMIN")
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
    /*return PasswordEncoderFactories.createDelegatingPasswordEncoder();*/
    return new BCryptPasswordEncoder();
  }
}
