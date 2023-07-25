package cl.awakelab.enrollApp.model.persistence.repository;

import cl.awakelab.enrollApp.model.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
  User findByUsername(String username);

}
