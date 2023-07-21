package cl.awakelab.enrollApp.web.controller;

import cl.awakelab.enrollApp.model.domain.dto.Teacher;
import cl.awakelab.enrollApp.web.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherRestController {
  private final TeacherService service;

  public TeacherRestController(TeacherService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<Teacher>> findAll(){
    return service.findAll()
            .map(teacher -> new ResponseEntity<>(teacher, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/{teacherId}")
  public ResponseEntity<Teacher> findById(@PathVariable int teacherId){
    return service.findById(teacherId)
            .map(teacher -> new ResponseEntity<>(teacher, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/create")
  public ResponseEntity<Teacher> create(@RequestBody Teacher teacher){
    return service.create(teacher)
            .map(t-> new ResponseEntity<>(t, HttpStatus.CREATED))
            .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
  }

  @PatchMapping("/update")
  public ResponseEntity<Teacher> update(@RequestBody Teacher teacher){
    return service.update(teacher)
            .map(t -> new ResponseEntity<>(t, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("/delete/{teacherId}")
  public ResponseEntity<Boolean> delete(@PathVariable int teacherId){
    return new ResponseEntity<Boolean>(service.delete(teacherId), HttpStatus.OK);
  }
}
