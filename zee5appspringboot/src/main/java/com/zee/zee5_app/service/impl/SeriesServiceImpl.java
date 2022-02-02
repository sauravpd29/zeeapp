

package com.zee.zee5_app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5_app.dto.Register;
import com.zee.zee5_app.dto.Series;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.exception.InvalidEmailException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;
import com.zee.zee5_app.exception.InvalidPasswordException;
import com.zee.zee5_app.repository.SeriesRepository;
import com.zee.zee5_app.service.SeriesService;

@Service
public class SeriesServiceImpl implements SeriesService {
	@Autowired
	private SeriesRepository seriesRepository;
	public SeriesServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
				Series register2=seriesRepository.save(series);
				if(register2!=null) {
					return "Success";
				}
				else {
					return "failure";
				}
	}

	@Override
	public Optional<Series> getSeriesById(String id)
			throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return seriesRepository.findById(id);
	}

	@Override
	public Series[] getAllSeries() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		List<Series> list = seriesRepository.findAll();
		Series[] array = new Series[list.size()];
		return list.toArray(array);
	}

	@Override
	public String modifySeries(String id, Series series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteSeries(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Series> optional =this.getSeriesById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("Record not found");
			}
			else {
				seriesRepository.deleteById(id);
				return "Success";
			}
		} catch (IdNotFoundException | InvalidIdLengthException | InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		seriesRepository.deleteById(id);
		return null;
	}

	@Override
	public Optional<List<Series>> getAllSeriesDetails() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(seriesRepository.findAll());
	}

	
}
