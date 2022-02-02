package com.zee.zee5_app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5_app.dto.Movie;
import com.zee.zee5_app.dto.Register;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.exception.InvalidEmailException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;
import com.zee.zee5_app.exception.InvalidPasswordException;
import com.zee.zee5_app.repository.MovieRepository;
import com.zee.zee5_app.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepository movieRepository;
	public MovieServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		Movie register2=movieRepository.save(movie);
		if(register2!=null) {
			return "Success";
		}
		else {
			return "failure";
		}
		//return null;
	}
//
//	@Override
//	public Optional<Movie> getMovieById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
//		// TODO Auto-generated method stub
//		return movieRepository.getMovieById(id);
//	}
//
//	@Override
//	public Movie[] getAllMovies() throws InvalidIdLengthException, InvalidNameException {
//		// TODO Auto-generated method stub
//		return movieRepository.getAllMovies();
//	}
//
//	@Override
//	public String modifyMovie(String id, Movie movie) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//		return movieRepository.modifyMovie(id, movie);
//	}
//
//	@Override
//	public String deleteMovie(String id) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//		return movieRepository.deleteMovie(id);
//	}
//
//	@Override
//	public Optional<List<Movie>> getAllMovieDetails() throws InvalidIdLengthException, InvalidNameException {
//		// TODO Auto-generated method stub
//		return movieRepository.getAllMovieDetails();
//	}

	@Override
	public Optional<Movie> getMovieById(String id)
			throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		//return null;
		return movieRepository.findById(id);
	}

	@Override
	public Movie[] getAllMovies() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		List<Movie> list =movieRepository.findAll();
		Movie[] array = new Movie[list.size()];
		return list.toArray(array);
		//return null;
	}

	@Override
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		//return null;
			try {
				Optional<Movie> optional =this.getMovieById(id);
			} catch (IdNotFoundException | InvalidIdLengthException | InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		movieRepository.deleteById(id);
		return null;
	}

	@Override
	public Optional<List<Movie>> getAllMovieDetails() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		//return null;
		return Optional.ofNullable(movieRepository.findAll());
	}

}
