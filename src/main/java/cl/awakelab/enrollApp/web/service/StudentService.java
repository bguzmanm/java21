package cl.awakelab.enrollApp.web.service;

import cl.awakelab.enrollApp.model.domain.dto.Student;

import java.util.List;

public interface StudentService {
  public List<Student> findAll();
  public Student findById(int id);
}
