package cl.awakelab.enrollApp.model.persistence.mapper;

import cl.awakelab.enrollApp.model.domain.dto.Course;
import cl.awakelab.enrollApp.model.persistence.entity.Curso;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TeacherMapper.class})
public interface CourseMapper {

  @Mappings({
          @Mapping(source = "id", target = "id"),
          @Mapping(source = "codigo", target = "code"),
          @Mapping(source = "nombre", target = "name"),
          @Mapping(source = "facilitador", target = "teacher"),
  })
  Course toCourse(Curso curso);
  List<Course> toCourses(List<Curso> cursos);
  @InheritInverseConfiguration
  Curso toCurso(Course course);
}
