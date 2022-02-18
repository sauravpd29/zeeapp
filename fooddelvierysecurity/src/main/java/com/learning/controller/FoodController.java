package com.learning.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dto.FOODTYPE;
import com.learning.dto.Food;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.exception.InvalidIdLengthException;
import com.learning.service.FoodService;

@RestController
@RequestMapping("/api/food")
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
//	POST request for adding food item
	@PostMapping("")
	@PreAuthorize(" hasRole('ADMIN')")
	public ResponseEntity<?> addFood(@RequestBody Food food) throws AlreadyExistsException {
		Food result = foodService.addFood(food);
		return ResponseEntity.status(201).body(result);
	}
	
//	GET request for retrieving food item by id
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<?> getFoodById(@PathVariable("id") String id) throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException {
		Optional<Food> optional = foodService.getFoodById(id);
		System.out.println("hello");
		return ResponseEntity.ok(optional.get());
	}
	
//	PUT request for updating food item by id
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateFood(@PathVariable("id") String id, @RequestBody Food food) throws IdNotFoundException {
		Food result = foodService.modifyFood( id,food);
		return ResponseEntity.status(200).body(result);
	}
	
//	GET request for retrieving all food items
	@GetMapping("")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<?> getAllFood() throws NameNotFoundException, InvalidIdLengthException {
		Optional<List<Food>> optional = foodService.getAllFood();
		if (optional.isEmpty()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("message", "No record found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
		return ResponseEntity.ok(optional.get());
	}
	
//	GET request for retrieving food item by food type
	@GetMapping("/type/{type}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<?> getFoodByType(@PathVariable("type") FOODTYPE foodType) throws NameNotFoundException, IdNotFoundException, InvalidIdLengthException {
		Optional<Optional<List<Food>>> optional = foodService.getFoodByFoodType(foodType);
		if (optional.isEmpty()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("message", "Sorry Food Not Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
		return ResponseEntity.ok(optional.get());
	}
	
//	DELETE request for deleting food item by id
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteFoodById(@PathVariable("id") String id) throws IdNotFoundException {
		foodService.deleteFood(id);
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "Food item deleted");
		return ResponseEntity.status(200).body(map);
	}

}
