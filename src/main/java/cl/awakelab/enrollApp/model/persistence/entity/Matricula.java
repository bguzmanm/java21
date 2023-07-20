package cl.awakelab.enrollApp.model.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "matricula")
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

  public Matricula() {
  }

  public Matricula(MatriculaPK id, Date fecha, Estudiante estudiante, Curso curso) {
    this.id = id;
    this.fecha = fecha;
    this.estudiante = estudiante;
    this.curso = curso;
  }

  public MatriculaPK getId() {
    return id;
  }

  public void setId(MatriculaPK id) {
    this.id = id;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public Estudiante getEstudiante() {
    return estudiante;
  }

  public void setEstudiante(Estudiante estudiante) {
    this.estudiante = estudiante;
  }

  public Curso getCurso() {
    return curso;
  }

  public void setCurso(Curso curso) {
    this.curso = curso;
  }
}
