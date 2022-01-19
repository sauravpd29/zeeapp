package com.zee.zee5app.subscription.repository;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.subscription.dto.Subscribe;





public class SubscriptionRepository {
	private Subscribe[] registers =new Subscribe[10];
	private static int count=-1;
	

	
	//to return all the user details
	public Subscribe[] getSubscription() {
		return registers;
	}
	public Subscribe updateSubscription(String id, Subscribe register) {
		for (Subscribe register1 : registers) {
			if(register1!=null && register1.getId().equals(id)) {
				String uid=register.getId();
				String Type=register.getType();
				String DateOfPurchase=register.getDateOfPurchase();
				String Status=register.getStatus();
				String PackCountry=register.getPackCountry();
				String PaymentMode=register.getPaymentMode();
				String Autorenewal=register.getAutorenewal();
				String ExpiryDate=register.getExpiryDate();
				
				register1.setId(uid);
				register1.setType(Type);
				register1.setDateOfPurchase(DateOfPurchase);
				register1.setStatus(Status);
				register1.setPackCountry(PackCountry);
				register1.setPaymentMode(PaymentMode);
				register1.setAutorenewal(Autorenewal);
				register1.setExpiryDate(ExpiryDate);
				
				System.out.println("Change successfull");
				return register1;
				
				
			}
		}
		
		return null;
	}
	int pos=0;
	public void deleteSubscription(String id) {
		for (Subscribe register : registers) {
			
			if(register!=null) {
				if(register.getId().equals(id))
				break;
			}
			pos++;
		}
			for(int i=pos;i<registers.length-1;i++) {
				registers[i]=registers[i+1];
			}
			for(int i=0;i<registers.length-1;i++) {
				System.out.println(registers[i]);
			}
		
		
	}
	public Subscribe getSubscriptionById(String id) {
		for (Subscribe register : registers) {
			if(register!=null && register.getId().equals(id)) {
				return(register);
			}
		}
		
		return(null);
	}
	public String addSubscription(Subscribe register) {
		
		if (count==registers.length-1) {
			Subscribe temp[]=new Subscribe[registers.length*2];
			System.arraycopy(registers, 0, temp, 0, registers.length);
			registers=temp;
			registers[++count]=register;
			return("Successfully handled");
		}
		registers[++count]=register;
		System.out.println(count);
		return("Success");
	}
	private static SubscriptionRepository subscriptionRepository;
	public static SubscriptionRepository getInstance() {
		if(subscriptionRepository==null)
			subscriptionRepository=new SubscriptionRepository();
		return subscriptionRepository;
	}


}
