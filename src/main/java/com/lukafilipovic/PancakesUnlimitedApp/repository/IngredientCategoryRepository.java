package com.lukafilipovic.PancakesUnlimitedApp.repository;

import com.lukafilipovic.PancakesUnlimitedApp.model.IngredientCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientCategoryRepository extends JpaRepository<IngredientCategory,Long> {
}
