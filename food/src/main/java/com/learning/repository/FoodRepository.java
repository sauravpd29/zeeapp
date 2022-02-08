package com.learning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.dto.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, String> {
	
	//find: retrieve details based on FoodName and language
	//boolean: exists
	
	//Boolean existsByFoodNameAndLanguage(String FoodName, String language);
	
	
	//Optional<Food> findByFoodNameAndLanguage(String foodName, String language);
	
	Optional<Food> findByFoodName(String foodName);
	
	//Optional<Food> findByFoodNameAndReleaseDate(String foodName, String releaseDate);
	
	//edit according to the api requests
	//Optional<Food> findByCast(String cast);
	
    
}
