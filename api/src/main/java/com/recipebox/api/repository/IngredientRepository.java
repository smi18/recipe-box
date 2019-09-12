package com.recipebox.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.recipebox.api.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
