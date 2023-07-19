package cl.awakelab.enrollApp.model.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "facilitador")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Facilitador {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String rut;
  private String nombre;
  private String email;
  private String telefono;
  @Column(name ="valor_hora")
  private float valorHora;
  private String banco;
  @Column(name ="cta_bancaria")
  private String cuentaBancaria;
}
