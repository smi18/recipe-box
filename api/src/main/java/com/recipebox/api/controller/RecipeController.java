package com.recipebox.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipebox.api.model.Recipe;
import com.recipebox.api.repository.RecipeRepository;

@RestController
public class RecipeController {

	private final RecipeRepository recipeRepository;
	
	RecipeController(RecipeRepository recipeRepository){
		this.recipeRepository = recipeRepository;
	}
	
	@GetMapping("/api/recipes")
	List<Recipe> all(){
		List<Recipe> recipeList = new ArrayList<>();
		recipeRepository.findAll().forEach(e->recipeList.add(e));
		return recipeList;
	}
}
