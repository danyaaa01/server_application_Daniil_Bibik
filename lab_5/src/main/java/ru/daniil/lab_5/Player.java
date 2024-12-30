package ru.prokhor.lab_5;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
@Entity
public class Player {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String position;
	
	public Player(){
	}
	
	public Player(String name, String position){
		this.name=name;
		this.position=position;
	}

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getPosition(){
        return position;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setPosition(String position) {
        this.position=position;
    }

}
