package com.example.foodorderingapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodorderingapplication.model.Meal;
import com.example.foodorderingapplication.response.ResponseHandler;
import com.example.foodorderingapplication.service.MealService;

@RestController
@RequestMapping("/meal")
public class MealController {

	@Autowired
	MealService mealService;

	@PostMapping("/addMeal")
	public ResponseEntity<Meal> addMeals(@RequestBody Meal meal) {
		mealService.save(meal);
		return new ResponseEntity<Meal>(mealService.save(meal), HttpStatus.CREATED);
	}

	@GetMapping("/findAllMeals")
	public Iterable<Meal> findAllMeals() {
		return mealService.select();
	}

	@PostMapping("/findMealById/{id}")
	public ResponseEntity<Object> findMealById(@PathVariable("id") int mealId) {
		return ResponseHandler.responseBuilder("Requested details are given here", HttpStatus.OK,
				mealService.get(mealId));
	}

	@DeleteMapping("/deleteMeal/{id}")
	public String deleteMeal(@PathVariable("id") int id) {
		mealService.delete(id);
		return "Meal deleted";
	}

	@DeleteMapping("/deleteAllMeals")
	public void deleteAllmeals() {
		mealService.removeAll();
	}

}
