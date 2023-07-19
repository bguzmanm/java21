package cl.awakelab.enrollApp.model.domain.dto;

import lombok.*;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Teacher {
  private int id;
  private String rut;
  private String name;
  private String email;
  private String phone;
  private float cost;
  private String bank;
  private String account;
}
