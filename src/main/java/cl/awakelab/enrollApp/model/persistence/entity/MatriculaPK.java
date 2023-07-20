package cl.awakelab.enrollApp.model.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
public class MatriculaPK implements Serializable {

  @Column(name = "estudiante_id")
  private Integer estudianteId;
  @Column(name = "curso_id")
  private Integer cursoId;

  public MatriculaPK() {
  }

  public MatriculaPK(Integer estudianteId, Integer cursoId) {
    this.estudianteId = estudianteId;
    this.cursoId = cursoId;
  }

  public Integer getEstudianteId() {
    return estudianteId;
  }

  public void setEstudianteId(Integer estudianteId) {
    this.estudianteId = estudianteId;
  }

  public Integer getCursoId() {
    return cursoId;
  }

  public void setCursoId(Integer cursoId) {
    this.cursoId = cursoId;
  }
}
