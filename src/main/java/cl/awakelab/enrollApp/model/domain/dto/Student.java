package cl.awakelab.enrollApp.model.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
  private int id;
  private String rut;
  private String name;
  private String email;
  private String phone;

}
