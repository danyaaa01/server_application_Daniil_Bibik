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


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
class JeansController {

  private static final Logger logger = LoggerFactory.getLogger(JeansController.class);

  @Autowired
  JeansRepository repository;

  JeansController(JeansRepository repository) {
    this.repository = repository;
  }
  @LogRequest
  @LogExecutionTime
  @GetMapping("/jeans")
  List<Jeans> all() {
	logger.info("Обрабатывается запрос методом GET на адрес /jeans");
    return repository.findAll();
  }
  @LogRequest
  @LogExecutionTime
  @PostMapping("/jeans")
  Jeans newJeans(@RequestBody Jeans newJeans) {
	logger.info("Обрабатывается запрос методом POST на адрес /jeans");
    return repository.save(newJeans);
  }
  @LogRequest
  @LogExecutionTime
  @GetMapping("/jeans/{id}")
  Jeans one(@PathVariable Long id) {
	logger.info("Обрабатывается запрос методом GET на адрес /jeans/"+String.valueOf(id));
	if(repository.findById(id).orElse(null)==null) {
		throw new ValidationException("1","Запись не найдена");
	}
    else
		return repository.findById(id).get();
  }
  @LogRequest
  @LogExecutionTime
  @PutMapping("/jeans/{id}")
  Jeans replaceJeans(@RequestBody Jeans newJeans, @PathVariable Long id) {
	logger.info("Обрабатывается запрос методом PUT на адрес /jeans/"+String.valueOf(id));
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
  @LogRequest
  @LogExecutionTime
  @DeleteMapping("/jeans/{id}")
  void deleteJeans(@PathVariable Long id) {
	logger.info("Обрабатывается запрос методом DELETE на адрес /jeans/"+String.valueOf(id));
	if(repository.findById(id).orElse(null)==null) {
		throw new ValidationException("2","Запись не существует");
	}
	else
		repository.deleteById(id);
  }
}