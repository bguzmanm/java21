package cl.awakelab.enrollApp.model.domain.service;

import cl.awakelab.enrollApp.model.domain.dto.Student;
import cl.awakelab.enrollApp.web.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudendServiceImpl implements StudentService {


  @Override
  public List<Student> findAll() {

    return null;
  }

  @Override
  public Student findById(int id) {
    return null;
  }
}
