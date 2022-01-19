package com.zee.zee5app.subscription.dto;

import lombok.Data;

@Data
public class Subscribe {
	private String type;
	private String dateOfPurchase;
	private String status;
	private String packCountry;
	private String paymentMode;
	private String autorenewal;
	private String expiryDate;
	private String id;
	//EDC
	public Subscribe() {
		System.out.println("Hello");
	}

}
