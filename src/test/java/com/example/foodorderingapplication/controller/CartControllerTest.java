package com.example.foodorderingapplication.controller;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.foodorderingapplication.model.Cart;
import com.example.foodorderingapplication.service.CartService;

class CartControllerTest {

	@InjectMocks
	private CartController cartController;

	@Mock
	private CartService cartService;

	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAddItemToCart() {

		Cart cart = new Cart();

		cartController.addItemToCart(cart);

		verify(cartService).addToCart(cart);

	}

	@Test
	void testFindAllCartItems() {

		cartController.findAllCartItems();

		verify(cartService).select();

	}

	@Test
	void testDeleteMealFromCartById() {
		int mealId = 2;

		cartController.deleteMealFromCartById(mealId);

		verify(cartService).deleteItemById(mealId);

	}

	@Test
	void testDeleteAllcartItems() {

		cartController.deleteAllcartItems();

		verify(cartService).deleteAllItems();

	}

}
