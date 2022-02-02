package com.zee.zee5_app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;

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
@Table(name="movie")
public class Movie implements Comparable<Movie>{
	
//	public Movie(String id, String name, int ageLimit, String cast, String genre, float length, String trailer,
//			String releaseDate, String language) throws InvalidIdLengthException, InvalidNameException {
//		super();
//		this.setId(id);
//		this.setName(name);
//		this.ageLimit = ageLimit;
//		this.cast = cast;
//		this.genre = genre;
//		this.length = length;
//		this.trailer = trailer;
//		this.releaseDate = releaseDate;
//		this.language = language;
//	}
@Id
	
@NotBlank
	private String id;
@NotBlank
	private String name;
@NotNull
	private int ageLimit;
@NotBlank
	private String cast;
@NotBlank
	private String genre;
@NotNull
	private float length;
	@NotBlank
	private String trailer;
	@NotBlank
	private String releaseDate;
	@NotBlank
	private String language;
	
	public void setId(String id) throws InvalidIdLengthException {
		if(id.length()<6)
			throw new InvalidIdLengthException("id length is less than 6");
		this.id = id;
	}
	
	public void setName(String name) throws InvalidNameException {
		if(name==null || name=="" || name.length()<2)
			throw new InvalidNameException("name is not valid");
		this.name = name;
	}
	
	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

}
