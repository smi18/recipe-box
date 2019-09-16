package com.recipebox.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.recipebox.api.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
