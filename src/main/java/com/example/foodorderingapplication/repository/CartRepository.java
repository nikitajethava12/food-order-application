package com.example.foodorderingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodorderingapplication.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
