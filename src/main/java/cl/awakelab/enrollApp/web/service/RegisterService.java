package cl.awakelab.enrollApp.web.service;

import cl.awakelab.enrollApp.model.domain.dto.Register;

import java.util.List;

public interface RegisterService {
  List<Register> findAll();
}
