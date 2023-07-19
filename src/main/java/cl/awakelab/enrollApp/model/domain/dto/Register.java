package cl.awakelab.enrollApp.model.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Register {
  private int studentId;
  private int courseId;
  private Student student;
  private Course course;
  private LocalDate date;
}
