package cl.awakelab.enrollApp.web.service;

import cl.awakelab.enrollApp.model.persistence.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
  Optional<List<User>> findAll();
  Optional<User> findById(String username);
  Optional<User> create(User user);
  Optional<User> update(User user);
  boolean delete(int id);
}
