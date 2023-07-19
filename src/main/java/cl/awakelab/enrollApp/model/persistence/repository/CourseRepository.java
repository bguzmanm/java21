package cl.awakelab.enrollApp.model.persistence.repository;

import cl.awakelab.enrollApp.model.persistence.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Curso, Integer> {
}
