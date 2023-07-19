package cl.awakelab.enrollApp.model.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "matricula")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Matricula {

  @EmbeddedId
  private MatriculaPK id;
  private Date fecha;
  @ManyToOne
  @MapsId("estudianteId")
  private Estudiante estudiante;
  @ManyToOne
  @MapsId("cursoId")
  private Curso curso;
}
