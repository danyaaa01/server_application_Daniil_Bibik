package ru.prokhor.lab_5;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class TeamController {
	
	@Autowired
	TeamRepository teamRepository;
	
    @GetMapping("/teams")
    public Iterable<Team> getTeams(){
        return teamRepository.findAll();
    }
	
	@GetMapping("/team/{id}")
    public Team getTeam(@PathVariable Long id){
        return teamRepository.findById(id).get();
    }
}
