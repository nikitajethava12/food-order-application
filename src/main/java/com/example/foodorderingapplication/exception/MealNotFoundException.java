package com.example.foodorderingapplication.exception;

public class MealNotFoundException extends RuntimeException {

	public MealNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public MealNotFoundException(String message) {
		super(message);
	}

}
