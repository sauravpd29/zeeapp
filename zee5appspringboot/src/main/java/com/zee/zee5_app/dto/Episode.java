package com.zee.zee5_app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity
@Table(name="episode")
public class Episode implements Comparable<Episode> {
	
//	public Episode(String id, String serId, String name, float length, String location, String trailer) {
//		super();
//		this.id = id;
//		this.serId = serId;
//		this.name = name;
//		this.length = length;
//		this.location = location;
//		this.trailer = trailer;
//	}
@Id
@NotBlank
	private String id;
@NotBlank
	private String serId;
@NotBlank
	private String name;
@NotNull
	private float length;
	@NotBlank
	private String location;
	@NotBlank
	private String trailer;
	
	@Override
	public int compareTo(Episode o) {
		// TODO Auto-generated method stub
		return o.id.compareTo(this.getId());
	}

}
