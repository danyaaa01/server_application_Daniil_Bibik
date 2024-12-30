package ru.prokhor.lab_5;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
class JeansController {

  @Autowired
  JeansRepository repository;

  JeansController(JeansRepository repository) {
    this.repository = repository;
  }


  @GetMapping("/jeans")
  List<Jeans> all() {
    return repository.findAll();
  }

  @PostMapping("/jeans")
  Jeans newJeans(@RequestBody Jeans newJeans) {
    return repository.save(newJeans);
  }
  
  @GetMapping("/jeans/{id}")
  Jeans one(@PathVariable Long id) {    
    return repository.findById(id).get();
      //.orElseThrow(() -> new EmployeeNotFoundException(id));
  }

  @PutMapping("/jeans/{id}")
  Jeans replaceJeans(@RequestBody Jeans newJeans, @PathVariable Long id) {    
    return repository.findById(id)
      .map(jeans -> {
        jeans.setBrand(newJeans.getBrand());
        jeans.setModel(newJeans.getModel());
		jeans.setColor(newJeans.getColor());
        return repository.save(jeans);
      })
      .orElseGet(() -> {
        return repository.save(newJeans);
      });
  }

  @DeleteMapping("/jeans/{id}")
  void deleteJeans(@PathVariable Long id) {
    repository.deleteById(id);
  }
}