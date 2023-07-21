package cl.awakelab.enrollApp.web.service;

import cl.awakelab.enrollApp.model.domain.dto.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
  Optional<List<Teacher>> findAll();
  Optional<Teacher> findById(int id);
  Optional<Teacher> create(Teacher teacher);
  Optional<Teacher> update(Teacher teacher);
  boolean delete(int id);
}
