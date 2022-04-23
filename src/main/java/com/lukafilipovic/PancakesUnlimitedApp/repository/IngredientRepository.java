package com.lukafilipovic.PancakesUnlimitedApp.repository;

import com.lukafilipovic.PancakesUnlimitedApp.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
}
