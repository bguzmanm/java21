package cl.awakelab.enrollApp.model.persistence.repository;

import cl.awakelab.enrollApp.model.persistence.entity.Matricula;
import cl.awakelab.enrollApp.model.persistence.entity.MatriculaPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Matricula, MatriculaPK> {
}
