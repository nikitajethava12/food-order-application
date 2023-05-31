package com.example.foodorderingapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodorderingapplication.model.Cart;
import com.example.foodorderingapplication.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	public Cart addToCart(Cart cart) throws IllegalArgumentException {
		Optional<Cart> cartOptional = cartRepository.findById(cart.getMealId());

		if (!cartOptional.isEmpty()) {
			Cart existingCart = cartOptional.get();
			existingCart.setMealQuantity(existingCart.getMealQuantity() + cart.getMealQuantity());
			cart = existingCart;
		}
//mealid -1 then throw exception  -illegalArgument
		return cartRepository.save(cart);

	}

	public List<Cart> save(List<Cart> listOfCart) {

		return cartRepository.saveAll(listOfCart);
	}

	public Iterable<Cart> select() {
		return cartRepository.findAll();

	}

	public String deleteItemById(int mealId) {
		cartRepository.deleteById(mealId);
		return "deleted";
	}

	public void deleteAllItems() {
		cartRepository.deleteAll();
	}

}
