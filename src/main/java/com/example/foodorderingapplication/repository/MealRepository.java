package com.example.foodorderingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodorderingapplication.model.Meal;

public interface MealRepository extends JpaRepository<Meal, Integer> {

}
