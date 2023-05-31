package com.example.foodorderingapplication.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.foodorderingapplication.model.Cart;
import com.example.foodorderingapplication.repository.CartRepository;

class CartServiceTest {

	@InjectMocks
	private CartService cartService;

	@Mock
	private CartRepository cartRepository;

	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testSave() {

		Cart cart = new Cart(1, 3);
		List<Cart> listCart = new ArrayList<Cart>();
		listCart.add(cart);
		cartService.save(listCart);

		verify(cartRepository).saveAll(listCart);

	}

	@Test
	void testSelect() {

		cartService.select();

		verify(cartRepository).findAll();

	}

	@Test
	void testDeleteItemById() throws Exception {

		Cart cart = new Cart();
		cartService.deleteItemById(cart.getMealId());

		verify(cartRepository).deleteById(cart.getMealId());

	}

	@Test
	void testDeleteAll() {

		cartService.deleteAllItems();
		verify(cartRepository).deleteAll();
	}

	@Test
	void testIllegalArgumentException() {
		Cart cart = new Cart(-1, 4);
		Optional<Cart> value = Optional.of(cart);

		when(cartRepository.findById(cart.getMealId())).thenThrow(new IllegalArgumentException()).thenReturn(value);
		when(cartRepository.save(Mockito.any(Cart.class))).thenReturn(cart);

		assertThrows(IllegalArgumentException.class, () -> {
			cartRepository.findById(cart.getMealId());
		});
	}

	@Test
	void testAddToCartNewEntry() {

		Cart cart = new Cart(20, 6);
		Optional<Cart> value = Optional.of(cart);

		when(cartRepository.findById(cart.getMealId())).thenReturn(value);
		when(cartRepository.save(Mockito.any(Cart.class))).thenReturn(cart);

		Cart addedItem = cartService.addToCart(cart);

		verify(cartRepository).save(cart);
		assertEquals(cart.getMealId(), addedItem.getMealId());
		assertEquals(cart.getMealQuantity(), addedItem.getMealQuantity());

	}

	@Test
	void testAddToCartUpdateQuantity() {

		Cart cart = new Cart(1, 3);
		Optional<Cart> value = Optional.of(cart);
		when(cartRepository.findById(cart.getMealId())).thenReturn(value);
		when(cartRepository.save(Mockito.any(Cart.class))).thenReturn(cart);

		Cart newCartObject = new Cart(1, 10);
		Cart addedItem = cartService.addToCart(newCartObject);

		assertEquals(cart.getMealId(), addedItem.getMealId());
		assertEquals(13, addedItem.getMealQuantity());

		assertNotEquals(newCartObject.getMealQuantity(), addedItem.getMealQuantity());

	}

}
