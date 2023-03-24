package com.execinema.restfulapi_cinetown.service;


import com.execinema.restfulapi_cinetown.api.model.CinemaDTO;
import com.execinema.restfulapi_cinetown.api.model.FilmDTO;
import com.execinema.restfulapi_cinetown.api.model.ListCinemaDTO;
import com.execinema.restfulapi_cinetown.api.model.ListFilmDTO;
import com.execinema.restfulapi_cinetown.domain.Cinema;
import com.execinema.restfulapi_cinetown.domain.City;
import com.execinema.restfulapi_cinetown.domain.Schedule;
import com.execinema.restfulapi_cinetown.repository.CinemaRepository;
import com.execinema.restfulapi_cinetown.repository.ScheduleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;
    private final ModelMapper modelMapper;

    public CinemaServiceImpl(CinemaRepository cinemaRepository, ModelMapper modelMapper) {
        this.cinemaRepository = cinemaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ListFilmDTO getFilmListByCinemaName(String cinemaName) {
        List<FilmDTO> filmDTOList = cinemaRepository.findById(cinemaName)
                .map(Cinema::getSchedules)
                .stream()
                .flatMap(Set::stream)
                .map(Schedule::getFilm)
                .map(film -> {
                    return modelMapper.map(film, FilmDTO.class);
                 /*   FilmDTO filmDTO = modelMapper.map(film, FilmDTO.class);
                    return filmDTO;*/
                })
                .collect(Collectors.toList());
        return new ListFilmDTO(filmDTOList);
    }

 /*   //Da ordinare dal meno distante al piu distante
    @Override
    public ListCinemaDTO getCinemaListByCityNameFilmNameAndProducer(String cityName,
                                                                    String filmName,
                                                                    String producer) {
        List<CinemaDTO> cinemaDTOList = cinemaRepository.findByCityName(cityName)
                .stream()
                .map(cinema -> {
                    return getCinemaDTO(filmName, producer, cinema);
                })
                .sorted(Comparator.comparing(CinemaDTO::getDistanceFromCityCenter))
                .collect(Collectors.toList());

      *//*  cinemaDTOList.stream()
                .sorted(Comparator.comparing(CinemaDTO::getDistanceFromCityCenter))
                .collect(Collectors.toList());*//*

        return new ListCinemaDTO(cinemaDTOList);
    }*/

    @Override
    public ListCinemaDTO getCinemaListByCityNameFilmNameProducerAndDistance(String cityName,
                                                                            String filmName,
                                                                            String producer,
                                                                            Double distance) {
        List<CinemaDTO> cinemaDTOList =
                cinemaRepository.findByCityNameAndDistanceFromCityCenterIsLessThanEqual(cityName, distance)
                        .stream()
                        .map(cinema -> {
                            return getCinemaDTO(filmName, producer, cinema);
                        })
                        .sorted(Comparator.comparing(CinemaDTO::getDistanceFromCityCenter))
                        .collect(Collectors.toList());

        return new ListCinemaDTO(cinemaDTOList);
    }

    @Override
    public void deleteCinemaByName(String cinemaName) {
        if (cinemaRepository.findById(cinemaName).isPresent()) {
            cinemaRepository.deleteById(cinemaName);
        }
    }

    private CinemaDTO getCinemaDTO(String filmName, String producer, Cinema cinema) {
        cinema.getSchedules()
                .stream()
                .map(schedule -> {
                    //scheduleRepository.findBy
                    //filter()
                    schedule.getFilm().setName(filmName);
                    schedule.getFilm().setProducer(producer);
                    return schedule;
                })
                .collect(Collectors.toList());
        return modelMapper.map(cinema, CinemaDTO.class);
    }


}
