package com.lukafilipovic.PancakesUnlimitedApp.repository;

import com.lukafilipovic.PancakesUnlimitedApp.model.Pancake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PancakeRepository extends JpaRepository<Pancake,Long> {

}
