package com.example.foodorderingapplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodorderingapplication.exception.MealNotFoundException;
import com.example.foodorderingapplication.model.Meal;
import com.example.foodorderingapplication.repository.MealRepository;

@Service
public class MealService {

	@Autowired
	private MealRepository mealRepository;

	public Meal save(Meal meal) {
		return mealRepository.save(meal);
	}

	public Iterable<Meal> select() {
		return mealRepository.findAll();

	}

	public void delete(Integer id) {
		mealRepository.deleteById(id);
	}

	public void removeAll() {
		mealRepository.deleteAll();
	}

	public void Update(Meal meal) {
		mealRepository.save(meal);

	}

	public Optional<Meal> get(int id) {
		if (mealRepository.findById(id).isEmpty())
			throw new MealNotFoundException("Requested Meal data does not exist in database");
		return mealRepository.findById(id);
	}

}
