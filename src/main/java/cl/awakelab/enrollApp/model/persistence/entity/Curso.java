package cl.awakelab.enrollApp.model.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="curso")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Curso {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String codigo;
  private String nombre;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_facilitador", insertable = false, updatable = false)
  private Facilitador facilitador;
}
