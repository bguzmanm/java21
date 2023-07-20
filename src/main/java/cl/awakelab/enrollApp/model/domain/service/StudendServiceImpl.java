package cl.awakelab.enrollApp.model.domain.service;

import cl.awakelab.enrollApp.model.domain.dto.Student;
import cl.awakelab.enrollApp.model.persistence.mapper.StudentMapper;
import cl.awakelab.enrollApp.model.persistence.repository.StudentRepository;
import cl.awakelab.enrollApp.web.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudendServiceImpl implements StudentService {

  private final StudentRepository repository;
  private final StudentMapper mapper;

  public StudendServiceImpl(StudentRepository repository, StudentMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public List<Student> findAll() {

    return mapper.toStudents(repository.findAll());
  }

  @Override
  public Student findById(int id) {
    return null;
  }
}
