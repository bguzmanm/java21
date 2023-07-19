package cl.awakelab.enrollApp.model.persistence.repository;

import cl.awakelab.enrollApp.model.persistence.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Estudiante, Integer> {
}
