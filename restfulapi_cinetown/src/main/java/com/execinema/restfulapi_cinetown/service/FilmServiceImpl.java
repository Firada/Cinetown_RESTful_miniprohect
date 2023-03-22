package com.execinema.restfulapi_cinetown.service;


import com.execinema.restfulapi_cinetown.api.model.FilmDTO;
import com.execinema.restfulapi_cinetown.domain.Film;

import com.execinema.restfulapi_cinetown.domain.FilmId;
import com.execinema.restfulapi_cinetown.repository.FilmRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService{

    private final FilmRepository filmRepository;
    private final ModelMapper modelMapper;

    public FilmServiceImpl(FilmRepository filmRepository, ModelMapper modelMapper) {
        this.filmRepository = filmRepository;
        this.modelMapper = modelMapper;
    }

    //POST
    @Override
    public FilmDTO createNewFilm(Film film) {
        Film newFilm = filmRepository.save(film);
        FilmDTO filmDTO = modelMapper.map(newFilm, FilmDTO.class);
        return filmDTO;
    }

    @Override
    public void deleteFilmByNameAndProducer(String filmName, String producer) {
        filmRepository.deleteFilmByNameAndProducer(filmName, producer);

    }

    @Override
    public void deleteFilmByName(String filmName) {
        filmRepository.deleteFilmByName(filmName);
    }


}
