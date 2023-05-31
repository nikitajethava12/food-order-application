package com.example.foodorderingapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MealExceptionHandler {

	@ExceptionHandler(value = { MealNotFoundException.class })
	public ResponseEntity<Object> handleMealNotFoundException(MealNotFoundException mealNotFoundException) {

		MealException mealException = new MealException(mealNotFoundException.getMessage(),
				mealNotFoundException.getCause(), HttpStatus.NOT_FOUND

		);
		return new ResponseEntity<>(mealException, HttpStatus.NOT_FOUND);
	}

}
