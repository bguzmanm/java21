package cl.awakelab.enrollApp.web.service;

import cl.awakelab.enrollApp.model.domain.dto.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
  Optional<List<Teacher>> findAll();
  Optional<Teacher> findById(int id);
  boolean create(Teacher teacher);
  boolean update(Teacher teacher);
  boolean delete(int id);
}
