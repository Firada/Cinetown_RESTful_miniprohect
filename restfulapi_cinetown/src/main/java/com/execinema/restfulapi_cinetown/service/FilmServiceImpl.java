package com.execinema.restfulapi_cinetown.service;


import com.execinema.restfulapi_cinetown.api.model.FilmDTO;
import com.execinema.restfulapi_cinetown.domain.Film;
import com.execinema.restfulapi_cinetown.domain.FilmId;
import com.execinema.restfulapi_cinetown.exception.ResourceNotFoundException;
import com.execinema.restfulapi_cinetown.repository.FilmRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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
    public FilmDTO createNewFilm(FilmDTO filmDTO) {

        Film newFilm = modelMapper.map(filmDTO, Film.class);
        filmRepository.save(newFilm);
        return filmDTO;
    }

    @Override
    public void deleteFilmByNameAndProducer(String filmName, String producer) {
        FilmId filmId = new FilmId(filmName, producer);

        Optional<Film> film = filmRepository.findById(filmId);
        if(film.isEmpty()){
            throw new ResourceNotFoundException("Film doesn't exist in db");
        }
        filmRepository.deleteById(filmId);
    }


    @Override
    @Transactional
    public void deleteFilmByName(String filmName){

        //dovrei definire il metodo nella repository per poterlo utilizzare
        /*Set<Film> findingFilms = filmRepository.findByFilmId_Name*/
        filmRepository.deleteAllByName(filmName);
    }


}
