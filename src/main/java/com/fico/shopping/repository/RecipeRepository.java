package com.fico.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fico.shopping.model.Recipe;
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

}
