package cl.awakelab.enrollApp.model.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "estudiante")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Estudiante {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String rut;
  private String nombre;
  private String email;
  private String telefono;
}
