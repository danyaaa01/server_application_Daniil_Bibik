package ru.prokhor.lab_5;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import java.util.Set;

@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String location;
    private String mascot;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="teamId")
	private Set<Player> set;
	
    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getLocation(){
        return location;
    }

    public String getMascot(){
        return mascot;
    }
	
	public Set<Player> getSet(){
        return set;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setLocation(String location) {
        this.location=location;
    }

    public void setMascot(String mascot) {
        this.mascot=mascot;
    }
	public void setSet(Set<Player> set) {
        this.set=set;
    }
}
