package cl.awakelab.enrollApp.model.persistence.mapper;

import cl.awakelab.enrollApp.model.domain.dto.Register;
import cl.awakelab.enrollApp.model.persistence.entity.Matricula;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StudentMapper.class, CourseMapper.class})
public interface RegisterMapper {

  @Mappings({
          @Mapping(source = "id.cursoId", target = "courseId"),
          @Mapping(source = "id.estudianteId", target = "studentId"),
          @Mapping(source = "fecha", target = "date"),
          @Mapping(source = "curso", target = "course"),
          @Mapping(source = "estudiante", target = "student"),
  })
  Register toRegister(Matricula matricula);
  List<Register> toRegisters(List<Matricula> matriculas);

  @InheritInverseConfiguration
  Matricula toMatricula(Register register);
}
