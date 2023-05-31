package com.example.foodorderingapplication.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodorderingapplication.model.Rating;
import com.example.foodorderingapplication.service.RatingService;

@RestController
public class RatingController {

	@Autowired
	RatingService ratingService;

	@PostMapping("/addRatings/{mealId}")
	public Rating save(@RequestBody Rating rating) {
		rating.setCreatedDate(LocalDate.now());
		return ratingService.save(rating);
	}

	@GetMapping("/findAllRatings")
	public List<Rating> getAll() {
		return ratingService.getAll();
	}

}
