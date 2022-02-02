package com.zee.zee5_app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5_app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity
@Table(name="subscription")
public class Subscription implements Comparable<Subscription> {
	
//	public Subscription(String id, String dateOfPurchase, String expiryDate, float amount, String paymentMode,
//			String status, String type, String autoRenewal, String regId) throws InvalidIdLengthException {
//		super();
//		this.setId(id);
//		this.dateOfPurchase = dateOfPurchase;
//		this.expiryDate = expiryDate;
//		this.amount = amount;
//		this.paymentMode = paymentMode;
//		this.status = status;
//		this.type = type;
//		this.autoRenewal = autoRenewal;
//		this.regId = regId;
//	}
@Id
	
	private String id;
@NotNull
	private String dateOfPurchase;
@NotNull
	private String expiryDate;
@NotNull
	private float amount;
@NotNull
	private String paymentMode;
@NotBlank
	private String status;
@NotBlank
	private String type;
@NotBlank
	private String autoRenewal;
	private String regId;
	
	public void setId(String id) throws InvalidIdLengthException {
		if(id.length()<6)
			throw new InvalidIdLengthException("id length is less than 6");
		this.id = id;
	}
	
	@Override
	public int compareTo(Subscription o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

}
