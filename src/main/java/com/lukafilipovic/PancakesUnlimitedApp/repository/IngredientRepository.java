package com.lukafilipovic.PancakesUnlimitedApp.repository;

import com.lukafilipovic.PancakesUnlimitedApp.model.Ingredient;
import com.lukafilipovic.PancakesUnlimitedApp.payload.Response.ReportResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {

    @Query(value = "SELECT ingredients.id as id, ingredients.name as name, COUNT(*) AS timesOrdered FROM ingredients\n" +
            "JOIN pancakes_with_ingredients ON pancakes_with_ingredients.ingredient_id=ingredients.id\n" +
            "JOIN pancakes ON pancakes_with_ingredients.pancake_id=pancakes.id\n" +
            "JOIN orders ON pancakes.order_id=orders.id\n" +
            "WHERE orders.ordered_at > DATE_ADD(NOW(), INTERVAL -1 MONTH)\n" +
            "GROUP BY ingredients.id ORDER BY timesOrdered DESC",
    nativeQuery = true)
    List<ReportResponse> getReportIngredients();

    @Query(value = "SELECT ingredients.id as id, ingredients.name as name, COUNT(*) AS timesOrdered FROM ingredients\n" +
            "JOIN pancakes_with_ingredients ON pancakes_with_ingredients.ingredient_id=ingredients.id\n" +
            "JOIN pancakes ON pancakes_with_ingredients.pancake_id=pancakes.id\n" +
            "JOIN orders ON pancakes.order_id=orders.id\n" +
            "WHERE orders.ordered_at > DATE_ADD(NOW(), INTERVAL -1 MONTH) AND ingredients.healthy=TRUE\n" +
            "GROUP BY ingredients.id ORDER BY timesOrdered DESC;",
    nativeQuery = true)
    List<ReportResponse> getReportHealthyIngredients();
}
