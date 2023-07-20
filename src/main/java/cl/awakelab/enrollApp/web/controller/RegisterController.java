package cl.awakelab.enrollApp.web.controller;

import cl.awakelab.enrollApp.web.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

  private final RegisterService service;

  public RegisterController(RegisterService service) {
    this.service = service;
  }

  @GetMapping
  public String findAll(Model model){
    model.addAttribute("registers", service.findAll());
    return "listRegister";
  }
}
