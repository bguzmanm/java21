package cl.awakelab.enrollApp.model.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {
  private int id;
  private String code;
  private String name;
  private Teacher teacher;
}
