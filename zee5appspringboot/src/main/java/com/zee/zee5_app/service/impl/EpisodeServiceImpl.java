package com.zee.zee5_app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5_app.dto.Episode;
import com.zee.zee5_app.dto.Register;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;
import com.zee.zee5_app.repository.EpisodeRepository;
import com.zee.zee5_app.service.EpisodeService;

@Service
public class EpisodeServiceImpl implements EpisodeService {
	@Autowired
	private EpisodeRepository episodeRepository;
	public  EpisodeServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addEpisode(Episode episode) {
		// TODO Auto-generated method stub
		Episode register2= episodeRepository.save(episode);
		if(register2!=null) {
			return "Success";
		}
		else {
			return "failure";
		}
		//return null;
	}


	@Override
	public Optional<Episode> getEpisodeById(String id)
			throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		//return null;
		return episodeRepository.findById(id);
	}

	@Override
	public Episode[] getAllEpisode() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		//return null;
		List<Episode> list =episodeRepository.findAll();
		Episode[] array = new Episode[list.size()];
		return list.toArray(array);
	}

	@Override
	public String modifyEpisode(String id, Episode episode) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEpisode(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		//return null;
		try {
			Optional<Episode> optional =this.getEpisodeById(id);
		} catch (IdNotFoundException | InvalidIdLengthException | InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		episodeRepository.deleteById(id);
		return null;
	}

	@Override
	public Optional<List<Episode>> getAllEpisodeDetails() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		//return null;
		return Optional.ofNullable(episodeRepository.findAll());
	}

}
