package ru.prokhor.lab_5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class Lab5Application {
	@Autowired
	JeansRepository jeansRepository;
	
	@PostConstruct
	public void init(){
		
		Jeans jeans = new Jeans();
		jeans.setBrand("Meu Porto");
		jeans.setModel("Джинсы багги");
		jeans.setColor("Чёрный");
		
		jeansRepository.save(jeans);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Lab5Application.class, args);
	}
	
	
}
