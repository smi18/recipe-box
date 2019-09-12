package com.recipebox.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.recipebox.api.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
