package com.example.foodorderingapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodorderingapplication.model.Rating;
import com.example.foodorderingapplication.repository.RatingRepository;

@Service
public class RatingService {

	@Autowired
	RatingRepository ratingRepository;

	public Rating save(Rating rating) {
		return ratingRepository.save(rating);
	}

	public Iterable<Rating> select() {

		return ratingRepository.findAll();
	}

	public List<Rating> getAll() {

		return ratingRepository.findAll();
	}

}
