package com.lukafilipovic.PancakesUnlimitedApp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String description;
    @Column(name = "ordered_at", nullable = false)
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime time;

    @OneToMany(mappedBy = "order", cascade = CascadeType.MERGE,orphanRemoval = true)
    private Set<Pancake> listOfPancakes=new HashSet<>();



}
