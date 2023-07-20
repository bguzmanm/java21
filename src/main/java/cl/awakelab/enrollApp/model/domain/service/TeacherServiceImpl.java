package cl.awakelab.enrollApp.model.domain.service;

import cl.awakelab.enrollApp.model.domain.dto.Teacher;
import cl.awakelab.enrollApp.model.persistence.entity.Facilitador;
import cl.awakelab.enrollApp.model.persistence.mapper.TeacherMapper;
import cl.awakelab.enrollApp.model.persistence.repository.TeacherRepository;
import cl.awakelab.enrollApp.web.service.TeacherService;
import org.springframework.stereotype.Service;

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
  public boolean create(Teacher teacher)
  {
    return repository.save(
            mapper.toFacilitador(teacher)
    ).getId()>0;
  }

  @Override
  public boolean update(Teacher teacher) {
    return repository.save(
            mapper.toFacilitador(teacher)
    ).getId() == teacher.getId();
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
