package cl.awakelab.enrollApp.web.security;

import cl.awakelab.enrollApp.model.persistence.entity.User;
import cl.awakelab.enrollApp.model.persistence.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository repository;

  public UserDetailsServiceImpl(UserRepository repository) {
    this.repository = repository;
  }

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = repository.findByUsername(username);
    if (user == null){
      throw new UsernameNotFoundException("Usuario no encontrado");
    }
    System.out.println(user.getUsername() + " " + user.getPassword());
    return new EnrollUserDetails(user);
  }
}
