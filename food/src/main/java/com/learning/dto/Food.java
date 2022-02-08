package com.learning.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;



import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "foodName")}, name = "food")
public class Food implements Comparable<Food> {
	
	@Id
	@Column(name = "id")
	//@Length(min = 6)
		
	private String id;
	
    @NotNull
	private String foodName;
    
    @NotNull
	private String foodCost;
    
	@NotNull
	private String description;
	
//	@NotBlank
	private String foodPic;
	
//	@NotNull
	private FOODTYPE foodtype;
	
	
	
	@Override
	public int compareTo(Food o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}
	

	
}