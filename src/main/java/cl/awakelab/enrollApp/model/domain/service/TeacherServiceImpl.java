package cl.awakelab.enrollApp.model.domain.service;

import cl.awakelab.enrollApp.model.domain.dto.Teacher;
import cl.awakelab.enrollApp.model.persistence.entity.Facilitador;
import cl.awakelab.enrollApp.model.persistence.mapper.TeacherMapper;
import cl.awakelab.enrollApp.model.persistence.repository.TeacherRepository;
import cl.awakelab.enrollApp.web.service.TeacherService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
  private final TeacherRepository repository;
  private final TeacherMapper mapper;

  public TeacherServiceImpl(TeacherRepository repository, TeacherMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public Optional<List<Teacher>> findAll() {
    return Optional.of(mapper.toTeachers(repository.findAll()));
  }

  @Override
  public Optional<Teacher> findById(int id) {
    return repository.findById(id).map(mapper::toTeacher);
  }

  @Override
  public Optional<Teacher> create(Teacher teacher)
  {
    return Optional.of(
            mapper.toTeacher(
                    repository.save(
                            mapper.toFacilitador(teacher)
                    )
            ));
  }

  @Override
  public Optional<Teacher> update(Teacher teacher) {
    if (repository.existsById(teacher.getId())){
      return Optional.of(
              mapper.toTeacher(
                      repository.save(
                              mapper.toFacilitador(teacher)
                      )
              ));
    }
    return Optional.of(new Teacher());
  }

  @Override
  public boolean delete(int id) {
    if (repository.existsById(id)){
      repository.deleteById(id);
      return true;
    }

    return false;
  }
}
