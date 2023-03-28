package com.execinema.restfulapi_cinetown.service;

import com.execinema.restfulapi_cinetown.api.model.CinemaDTO;
import com.execinema.restfulapi_cinetown.api.model.FilmDTO;
import com.execinema.restfulapi_cinetown.api.model.ListCinemaDTO;
import com.execinema.restfulapi_cinetown.api.model.ListFilmDTO;
import com.execinema.restfulapi_cinetown.domain.Cinema;
import com.execinema.restfulapi_cinetown.domain.Schedule;
import com.execinema.restfulapi_cinetown.exception.ResourceNotFoundException;
import com.execinema.restfulapi_cinetown.exception.WrongParamFormatException;
import com.execinema.restfulapi_cinetown.repository.CinemaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashSet;
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
    
    //testing my stuff
  /*  public ListCinemaDTO getCinemaAAAAAAAAAAListByCityNameFilmNameProducerAndDistance(String cityName,
                                                                            String filmName,
                                                                            String producer,
                                                                            Double distance) {
    
     *//*   List<CinemaDTO> cinemaDTOList = cinemaRepository.findByCityNameAndDistanceFromCityCenterIsLessThanEqual(cityName, distance)
                .stream()
                .map(Cinema::getSchedules)
                .flatMap(Set::stream)
                .map(Schedule::getFilm)
                .anyMatch(film -> {
                    film.getName().equals(filmName) && film.getProducer().equals(producer);
                })
                .collect(Collectors.toSet());
*//*

        return new ListCinemaDTO(cinemaDTOList);
    }*/

    @Override
    public ListCinemaDTO getCinemaListByCityNameFilmNameProducerAndDistance(String cityName,
                                                                            String filmName,
                                                                            String producer,
                                                                            Double distance) {

        Set<Cinema> cinemaSet = new HashSet<>();

        if (distance == null) {
            distance = Double.MAX_VALUE;
        }

        if (distance == 0) {
            throw new WrongParamFormatException("Value must be higher than 0");
        }
        cinemaRepository.findByCityNameAndDistanceFromCityCenterIsLessThanEqual(cityName, distance)
                .forEach(cinema -> {
                    /*return getCinemaDTO(filmName, producer, cinema);*/
                    cinema.getSchedules()
                            .forEach(schedule -> {
                                if (schedule.getFilm().getName().equals(filmName)
                                        && schedule.getFilm().getProducer().equals(producer)) {
                                    cinemaSet.add(cinema);
                                }
                            });
                });

        List<CinemaDTO> cinemaDTOS = cinemaSet.stream()
                .map(cinema -> {
                    return modelMapper.map(cinema, CinemaDTO.class);
                })
                .sorted(Comparator.comparing(CinemaDTO::getDistanceFromCityCenter))
                .collect(Collectors.toList());


        return new ListCinemaDTO(cinemaDTOS);
    }

    @Override
    public void deleteCinemaByName(String cinemaName) {
        if (cinemaRepository.findById(cinemaName).isPresent()) {
            cinemaRepository.deleteById(cinemaName);
        } else {
            throw new ResourceNotFoundException("This cinema name: " + cinemaName + " doesn't exists");
        }
    }

    private CinemaDTO getCinemaDTO(String filmName, String producer, Cinema cinema) {
        Set<Schedule> scheduleSet = cinema.getSchedules()
                .stream()
                .filter(schedule -> {
                    return schedule.getFilm().getName().equals(filmName)
                            && schedule.getFilm().getProducer().equals(producer);

                })
                .collect(Collectors.toSet());
        cinema.setSchedules(scheduleSet);
        return modelMapper.map(cinema, CinemaDTO.class);
    }





}
