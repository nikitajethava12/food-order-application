package com.example.foodorderingapplication.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Getter
@Setter
@Entity
@Table(name = "Rating")
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ratingId;

	private LocalDate createdDate = LocalDate.now();

	private int mealId;

	private int mealRating;

	private String mealComments;

	@OneToOne(targetEntity = Meal.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "mealId", referencedColumnName = "mealId")

	public int getRatingId() {
		return ratingId;
	}

	public Rating(int ratingId, LocalDate createdDate, int mealId, int mealRating, String mealComments) {
		super();
		this.ratingId = ratingId;
		this.createdDate = createdDate;
		this.mealId = mealId;
		this.mealRating = mealRating;
		this.mealComments = mealComments;
	}

	public Rating() {
	}

}
