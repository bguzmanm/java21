package cl.awakelab.enrollApp.model.persistence.repository;

import cl.awakelab.enrollApp.model.persistence.entity.Facilitador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Facilitador, Integer> {
}
