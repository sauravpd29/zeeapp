package com.learning.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.dto.FOODTYPE;
import com.learning.dto.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, String> {
	
//	Optional<Movie> findByName(String name);
//	Optional<Movie> findByNameAndLanguage(String name, String language);
//	Optional<Movie> findByNameAndReleaseDate(String name, String releaseDate);
//	Optional<List<Movie>> findAllByCast(String cast);
//	Boolean existsByName(String name);
	Optional<List<Food>> findByFoodType(FOODTYPE foodType);
	

}
