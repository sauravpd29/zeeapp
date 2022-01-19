package com.zee.zee5app.subscription;
import com.zee.zee5app.subscription.repository.*;
import com.zee.zee5app.subscription.service.*;



import com.zee.zee5app.dto.Register;
import com.zee.zee5app.subscription.dto.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subscribe register=new Subscribe();
		register.setType("Annual");
		register.setDateOfPurchase("18-02-1998");
		register.setStatus("Active");
		register.setPackCountry("India");
		register.setPaymentMode("Debit Card");
		register.setPackCountry("India");
		register.setAutorenewal("No");
		register.setExpiryDate("18-02-1999");
		register.setId("sub001");
		System.out.println(register);
		System.out.println(register.toString());
		System.out.println(register.getType());
		
		SubscriptionService service = SubscriptionService.getInstance();
		for(int i=0;i<=11;i++) {
			Subscribe register2=new Subscribe();
			register2.setType("Annual"+i);
			register2.setDateOfPurchase("18-02-1998"+i);
			register2.setStatus("Active"+i);
			register2.setPackCountry("India"+i);
			register2.setPaymentMode("Debit Card"+i);
			register2.setPackCountry("India"+i);
			register2.setAutorenewal("No");
			register2.setExpiryDate("18-02-1999"+i);
			register2.setId("sub001"+i);
			String result=service.addSubscription(register2);
			
			System.out.println(result);
		}
		Subscribe register2=service.getSubscriptionById("sub0010");
		System.out.println("Hi");
		System.out.println(register2!=null);
		for(Subscribe register3:service.getSubscription()) {
			System.out.println(register3);
		}
		
		String id="sub0012";
		Subscribe register4=new Subscribe();
		register4.setType("Monthly");
		register4.setDateOfPurchase("18-02-1998");
		register4.setStatus("Expired");
		register4.setPackCountry("USA");
		register4.setPaymentMode("Credit Card");
		register4.setPackCountry("India");
		register4.setAutorenewal("No");
		register4.setExpiryDate("18-03-1999");
		register4.setId(id);
		Subscribe register5=service.updateSubscription(id, register4);
		System.out.println(register5);
		service.deleteSubscription("sub0015");
		
		

	}

}


