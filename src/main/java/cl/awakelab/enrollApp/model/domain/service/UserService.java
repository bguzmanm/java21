package cl.awakelab.enrollApp.model.domain.service;

import cl.awakelab.enrollApp.model.persistence.entity.User;
import cl.awakelab.enrollApp.model.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService  implements cl.awakelab.enrollApp.web.service.UserService {

  UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<List<User>> findAll() {
    return Optional.empty();
  }

  @Override
  public Optional<User> findById(String username) {
    return Optional.empty();
  }

  @Override
  public Optional<User> create(User user) {
    return Optional.empty();
  }

  @Override
  public Optional<User> update(User user) {
    return Optional.empty();
  }

  @Override
  public boolean delete(int id) {
    return false;
  }
}
