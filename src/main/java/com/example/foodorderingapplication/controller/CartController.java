package com.example.foodorderingapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodorderingapplication.model.Cart;
import com.example.foodorderingapplication.service.CartService;

@RequestMapping("/cart")
@RestController
public class CartController {

	@Autowired(required = true)
	private CartService cartService;

	@PostMapping("/addToCart")
	public Cart addItemToCart(@RequestBody Cart cart) {
		return cartService.addToCart(cart);

	}

	@GetMapping("/findAllItemsOfCart")
	public Iterable<Cart> findAllCartItems() {
		return cartService.select();
	}

	@DeleteMapping("/deleteAllItemsFromCart")
	public String deleteAllcartItems() {
		cartService.deleteAllItems();
		return "All items are deleted from cart";
	}

	@DeleteMapping("/deleteMealFromCartById/{id}")
	public String deleteMealFromCartById(@PathVariable("id") int mealId) {
		cartService.deleteItemById(mealId);
		return "Meal Deleted";
	}

}
