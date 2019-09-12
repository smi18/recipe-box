package com.recipebox.api.model;

import java.io.Serializable;

import javax.persistence.*;
@Entity
//@Table(name = "categories")
public class Category{
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    public Category() {
        super();
    }

    public Category(String name) {
        super();
        this.name = name;
    }
    
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}