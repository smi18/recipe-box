package com.recipebox.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recipebox.api.model.Category;
import com.recipebox.api.repository.CategoryRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
	
	private final CategoryRepository categoryRepository;
	
	CategoryController(CategoryRepository repository) {
		this.categoryRepository = repository;
	}

	@GetMapping("/categories")
	List<Category> all(){
		List<Category> categoryList = new ArrayList<>();
		categoryRepository.findAll().forEach(e->categoryList.add(e));
		return categoryList;
	}
	
	@PostMapping("/categories")
    void addCategory(@RequestBody Category category) {
		categoryRepository.save(category);
    }
}
