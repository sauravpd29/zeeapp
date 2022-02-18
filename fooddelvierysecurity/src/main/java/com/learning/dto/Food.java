package com.learning.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.learning.dto.Food;
import com.learning.utils.StringPrefixedSequenceIdGenerator;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Entity
@Table(name = "food", uniqueConstraints = { @UniqueConstraint(columnNames = "foodName") })
public class Food implements Comparable<Food> {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    @GenericGenerator(
        name = "my_seq", 
        strategy = "com.learning.utils.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "Food_"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d") })
	
	private String id;

	@NotNull
	private String foodName;

	@NotNull
	private String foodCost;

//	@NotNull
	private String description;

//	@NotBlank
	private String foodPic;

//	@NotNull
	private FOODTYPE foodType;

	@Override
	public int compareTo(Food o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

}
