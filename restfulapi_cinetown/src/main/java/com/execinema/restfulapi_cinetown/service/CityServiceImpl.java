package com.execinema.restfulapi_cinetown.service;


import com.execinema.restfulapi_cinetown.api.model.*;
import com.execinema.restfulapi_cinetown.domain.Cinema;
import com.execinema.restfulapi_cinetown.domain.City;

import com.execinema.restfulapi_cinetown.domain.Schedule;
import com.execinema.restfulapi_cinetown.repository.CinemaRepository;
import com.execinema.restfulapi_cinetown.repository.CityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;
import java.util.Set;

import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CinemaRepository cinemaRepository;
    private final ModelMapper modelMapper;

    public CityServiceImpl(CityRepository cityRepository, CinemaRepository cinemaRepository, ModelMapper modelMapper) {
        this.cityRepository = cityRepository;
        this.cinemaRepository = cinemaRepository;
        this.modelMapper = modelMapper;
    }

    //GET
    @Override
    public ListCinemaDTO getCinemaListByCityName(String cityName) {
        List<CinemaDTO> cinemaDTOList = cityRepository.findById(cityName)
                .get()
                .getCinemas()
                .stream()
                .map(cinema -> {
                    return modelMapper.map(cinema, CinemaDTO.class);
                })
                .collect(Collectors.toList());

        return new ListCinemaDTO(cinemaDTOList);
    }

    @Override
    public ListFilmDTO getFilmListByCityName(String cityName) {
        List<FilmDTO> filmDTOList = cityRepository.findById(cityName)
                .map(City::getCinemas)
                .stream()
                .flatMap(Set::stream)
                .map(Cinema::getSchedules)
                .flatMap(Set::stream)
                .map(Schedule::getFilm)
                .map(film -> {
                    return modelMapper.map(film, FilmDTO.class);
                })
                .collect(Collectors.toList());

        return new ListFilmDTO(filmDTOList);
    }

    //POST
    @Override
    public CinemaDTO createNewCinemaInCity(String cityName, CinemaDTO cinemaDTO) {

        Cinema cinema = modelMapper.map(cinemaDTO, Cinema.class);
        Optional<City> optionalCity = cityRepository.findById(cityName);
        City city;

        if (optionalCity.isPresent()) {
            city = optionalCity.get();
        } else {
            city = new City(cityName);
      /*      city.setCinemas(new HashSet<>());*/
        }
        city.getCinemas().add(cinema);
        cityRepository.save(city);

        return cinemaDTO;
    }
}
