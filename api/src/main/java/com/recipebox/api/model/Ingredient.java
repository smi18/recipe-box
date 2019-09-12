package com.recipebox.api.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
//@Table(name = "ingredients")
public class Ingredient{
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotNull
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    
    @ManyToMany(mappedBy = "recipes")
    private Set<Recipe> recipes = new HashSet<>();
 
    
    public Set<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(Set<Recipe> recipes) {
		this.recipes = recipes;
	}

	public Ingredient() {
        super();
    }

    public Ingredient(String name) {
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
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
	        Ingredient ingredient = (Ingredient) o;
	        return Objects.equals(name, ingredient.name);
	}
	 
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}