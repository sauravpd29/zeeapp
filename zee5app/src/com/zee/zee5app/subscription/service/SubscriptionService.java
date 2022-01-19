package com.zee.zee5app.subscription.service;

import com.zee.zee5app.subscription.dto.*;
import com.zee.zee5app.subscription.repository.*;


public class SubscriptionService {
	private SubscriptionRepository repository=SubscriptionRepository.getInstance();
	//service is consuming the repository
	
	
	private static SubscriptionService service=null;
	public static SubscriptionService getInstance() {
		if (service==null)
			service=new SubscriptionService();
		return(service);
		
	}
	public String addSubscription(Subscribe register) {
		return this.repository.addSubscription(register);
		
	}
	public Subscribe getSubscriptionById(String id) {
		return repository.getSubscriptionById(id);
	}
	public Subscribe updateSubscription(String id, Subscribe register) {
		return repository.updateSubscription(id, register);
	}
	public void deleteSubscription(String id) {
		repository.deleteSubscription(id);
	}
	public Subscribe[] getSubscription() {
		return repository.getSubscription();
	}

}
