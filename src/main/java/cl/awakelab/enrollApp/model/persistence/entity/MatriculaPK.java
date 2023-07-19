package cl.awakelab.enrollApp.model.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MatriculaPK implements Serializable {
  @Column(name="id_estudiante")
  private Integer estudianteId;
  @Column(name="id_curso")
  private Integer cursoId;
}
