package com.learning.service;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import com.learning.dto.FOODTYPE;
import com.learning.dto.Food;
import com.learning.exception.IdNotFoundException;
import com.learning.exception.InvalidIdLengthException;

public interface FoodService {
	
//	public Movie addMovie(Movie movie) throws AlreadyExistsException;
//	public Optional<Movie> getMovieById(String id) throws IdNotFoundException;
//	public Movie[] getAllMovies();
//	public String deleteMovie(String id) throws IdNotFoundException;
//	public Optional<List<Movie>> getAllMovieDetails();
	
	public Food addFood(Food food);
	public String deleteFood(String id) throws IdNotFoundException;
	public Food modifyFood(String id, Food food) throws IdNotFoundException;
	public Optional<Food> getFoodById(String id) throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException;
	public Optional<List<Food>> getAllFood() throws NameNotFoundException, InvalidIdLengthException;
	public Optional<Optional<List<Food>>> getFoodByFoodType(FOODTYPE foodType) throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException;
	

}
