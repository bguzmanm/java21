package cl.awakelab.enrollApp.model.persistence.mapper;

import cl.awakelab.enrollApp.model.domain.dto.Student;
import cl.awakelab.enrollApp.model.persistence.entity.Estudiante;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

  @Mappings({
          @Mapping(source = "id", target = "id"),
          @Mapping(source = "nombre", target = "name"),
          @Mapping(source = "rut", target = "rut"),
          @Mapping(source = "email", target = "email"),
          @Mapping(source = "telefono", target = "phone"),
  })
  Student toStudent(Estudiante estudiante);
  List<Student> toStudents(List<Estudiante> estudiantes);
  @InheritInverseConfiguration
  Estudiante toEstudiante(Student student);
}
