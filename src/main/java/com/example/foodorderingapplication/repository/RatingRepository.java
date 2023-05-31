package com.example.foodorderingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodorderingapplication.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
