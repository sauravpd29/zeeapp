
package com.zee.zee5_app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5_app.dto.Register;
import com.zee.zee5_app.dto.Series;
import com.zee.zee5_app.dto.Subscription;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.exception.InvalidEmailException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;
import com.zee.zee5_app.exception.InvalidPasswordException;
import com.zee.zee5_app.repository.SubscriptionRepository;
import com.zee.zee5_app.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	public SubscriptionServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addSubscription(Subscription subscription) {
		Subscription register2=subscriptionRepository.save(subscription);
		if(register2!=null) {
			return "Success";
		}
		else {
			return "failure";
		}
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException, InvalidIdLengthException {
		return subscriptionRepository.findById(id);
	}

	@Override
	public Subscription[] getAllSubscriptions() throws InvalidIdLengthException {
		// TODO Auto-generated method stub
		List<Subscription> list = subscriptionRepository.findAll();
		Subscription[] array = new Subscription[list.size()];
		return list.toArray(array);
	}

	@Override
	public String modifySubscription(String id, Subscription subscription) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteSubscription(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Subscription> optional =this.getSubscriptionById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("Record not found");
			}
			else {
				subscriptionRepository.deleteById(id);
				return "Success";
			}
		} catch (IdNotFoundException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		subscriptionRepository.deleteById(id);
		return null;
	}

	@Override
	public Optional<List<Subscription>> getAllSubscriptionDetails() throws InvalidIdLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(subscriptionRepository.findAll());
	}

	

}
