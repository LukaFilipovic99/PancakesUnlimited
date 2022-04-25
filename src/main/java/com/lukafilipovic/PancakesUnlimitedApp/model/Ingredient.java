package com.lukafilipovic.PancakesUnlimitedApp.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private IngredientCategory category;

    @ManyToMany(mappedBy = "pancakeIngredients", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Pancake> pancakes=new HashSet<>();
}
