package com.example.foodorderingapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Getter
@Setter
@Entity
@Builder
@Table(name = "meal")
public class Meal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mealId;

	private String mealName;
	private int mealPrice;
	private String mealDescription;

	public Meal(int mealId, String mealName, int mealPrice, String mealDescription) {
		super();
		this.mealId = mealId;
		this.mealName = mealName;
		this.mealPrice = mealPrice;
		this.mealDescription = mealDescription;
	}

	public Meal() {
		super();
	}

}
