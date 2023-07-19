package cl.awakelab.enrollApp.web.controller;

import cl.awakelab.enrollApp.web.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

  private final StudentService service;

  public StudentController(StudentService service) {
    this.service = service;
  }

  @GetMapping
  public String findAll(Model model){
    model.addAttribute(service.findAll());
    return "listStudent";
  }
}
