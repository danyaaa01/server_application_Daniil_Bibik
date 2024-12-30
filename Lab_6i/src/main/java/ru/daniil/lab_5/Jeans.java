package ru.prokhor.lab_5;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Jeans {
    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String model;
    private String color;
	
    public Long getId(){
        return id;
    }

    public String getBrand(){
        return brand;
    }

    public String getModel(){
        return model;
    }

    public String getColor(){
        return color;
    }
	
    public void setId(Long id) {
        this.id=id;
    }

    public void setBrand(String brand) {
        this.brand=brand;
    }

    public void setModel(String model) {
        this.model=model;
    }

    public void setColor(String color) {
        this.color=color;
    }

}
