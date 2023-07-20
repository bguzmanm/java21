package cl.awakelab.enrollApp.model.domain.service;

import cl.awakelab.enrollApp.model.domain.dto.Register;
import cl.awakelab.enrollApp.model.persistence.entity.Matricula;
import cl.awakelab.enrollApp.model.persistence.mapper.RegisterMapper;
import cl.awakelab.enrollApp.model.persistence.repository.RegisterRepository;
import cl.awakelab.enrollApp.web.service.RegisterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

  private final RegisterRepository repository;
  private final RegisterMapper mapper;

  public RegisterServiceImpl(RegisterRepository repository, RegisterMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public List<Register> findAll() {

    Matricula m = new Matricula();

    return this.mapper.toRegisters(repository.findAll());
  }
}
