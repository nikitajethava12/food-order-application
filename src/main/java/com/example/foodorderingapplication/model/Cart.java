package com.example.foodorderingapplication.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Getter
@Setter
@Entity
@Table(name = "Cart")
public class Cart {

	@Id
	private int mealId;
	private int mealQuantity;

	@OneToOne(targetEntity = Meal.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "mealId", referencedColumnName = "mealId")

	public int getMealId() {
		return mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	public int getMealQuantity() {
		return mealQuantity;
	}

	public void setMealQuantity(int mealQuantity) {
		this.mealQuantity = mealQuantity;
	}

	public Cart(int mealId, int mealQuantity) {
		super();
		this.mealId = mealId;
		this.mealQuantity = mealQuantity;
	}

	public Cart() {
		super();
	}

}
