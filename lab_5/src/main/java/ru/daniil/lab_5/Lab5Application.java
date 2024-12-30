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
	TeamRepository teamRepository;
	@Autowired
	JeansRepository jeansRepository;
	
	@PostConstruct
	public void init(){
		List<Team> list = new ArrayList<>();
		Set<Player> set = new HashSet<>();
		
        Team team = new Team();
		set.add(new Player("Станислав Черчесов","GK"));
		set.add(new Player("Дмитрий Буряк","FW"));
        team.setName("Таврия");
        team.setLocation("Симферополь");
        team.setMascot("Пчела");
		team.setSet(set);
        list.add(team);

        team = new Team();
        team.setName("Черноморец");
        team.setLocation("Феодосия");
        team.setMascot("Барабулька");
		team.setSet(null);
        list.add(team);

        teamRepository.saveAll(list);
		
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
