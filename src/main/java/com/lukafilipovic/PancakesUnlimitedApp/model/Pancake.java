package com.lukafilipovic.PancakesUnlimitedApp.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "pancakes")
public class Pancake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="pancakes_with_ingredients",
            joinColumns=@JoinColumn(name="pancake_id", nullable = false),
            inverseJoinColumns=@JoinColumn(name = "ingredient_id", nullable = false)
    )
    private Set<Ingredient> pancakeIngredients=new HashSet<>();

}
