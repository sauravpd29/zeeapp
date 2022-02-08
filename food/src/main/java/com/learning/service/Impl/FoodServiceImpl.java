package com.learning.service.Impl;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learning.dto.Food;
//import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.exception.InvalidIdLengthException;
import com.learning.repository.FoodRepository;
import com.learning.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {


	@Autowired
	private FoodRepository repository ;
	
	@Override
	//@org.springframework.transaction.annotation.Transactional(rollbackFor = AlreadyExistsException.class)
	public Food addFood(Food food) {
//		repository.findById(food.getId());
//		if(status) {
//			throw new AlreadyExistsException("this record already exists");
//		}
		Food food2 = repository.save(food);
		if (food2 != null) {
			//return "record added in food";
			return food2;
		} else {
			return null;
		}
	}

	@Override
	public String deleteFood(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Food> optional;
		try {
			optional = this.getFoodById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				repository.deleteById(id);
				return "foods record deleted";
			}
		} catch (IdNotFoundException | InvalidIdLengthException | NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public String modifyFood(String id, Food food) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Food> getFoodById(String id) throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Optional<List<Food>> getAllFood() throws NameNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findAll());
	}

	@Override
	public Optional<Food> getFoodByFoodType(String foodType)
			throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return null;
	}
    

}
