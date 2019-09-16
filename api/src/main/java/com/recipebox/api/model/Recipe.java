package com.recipebox.api.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
//@Table(name = "recipes")
public class Recipe{
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "recipe_desc", nullable = false, length = 2000)
    private String desc;
    
    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "recipe_ingredient",
    	    joinColumns = @JoinColumn(name = "recipe_id"),
    	    inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    	)
    //@JoinTable(name ="recipe_ingredient", joinColumns = @JoinColumn(name = "recipe_fk"), inverseJoinColumns = @JoinColumn(name = "ingredient_fk"))
    private Set<Ingredient> ingredients = new HashSet<>();
    
    public Recipe() {
        super();
    }

    public Recipe(String name, String desc) {
        super();
        this.name = name;
        this.desc = desc;
    }
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Category getCategory() {
		return category;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
		ingredient.getRecipes().add(this);
    }
 
    public void removeIngredient(Ingredient ingredient) {
    	ingredients.remove(ingredient);
        ingredient.getRecipes().remove(this);
    }
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(name, recipe.name);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}