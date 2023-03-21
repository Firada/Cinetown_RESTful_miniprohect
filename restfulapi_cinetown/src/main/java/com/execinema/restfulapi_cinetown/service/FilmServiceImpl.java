package com.execinema.restfulapi_cinetown.service;

import com.execinema.restfulapi_cinetown.api.mapper.FilmMapper;
import com.execinema.restfulapi_cinetown.api.model.FilmDTO;
import com.execinema.restfulapi_cinetown.domain.Film;

import com.execinema.restfulapi_cinetown.repository.FilmRepository;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService{

    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;

    public FilmServiceImpl(FilmRepository filmRepository, FilmMapper filmMapper) {
        this.filmRepository = filmRepository;
        this.filmMapper = filmMapper;
    }


    //POST
    @Override
    public FilmDTO createNewFilm(Film film) {
        Film newFilm = filmRepository.save(film);
        FilmDTO filmDTO = filmMapper.filmToFilmDTO(newFilm);
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
