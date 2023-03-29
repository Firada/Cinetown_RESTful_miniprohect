package com.execinema.restfulapi_cinetown.service;


import com.execinema.restfulapi_cinetown.api.model.CinemaDTO;
import com.execinema.restfulapi_cinetown.api.model.FilmDTO;
import com.execinema.restfulapi_cinetown.api.model.ListCinemaDTO;
import com.execinema.restfulapi_cinetown.api.model.ListFilmDTO;
import com.execinema.restfulapi_cinetown.domain.Cinema;
import com.execinema.restfulapi_cinetown.domain.City;
import com.execinema.restfulapi_cinetown.domain.Schedule;
import com.execinema.restfulapi_cinetown.repository.CinemaRepository;
import com.execinema.restfulapi_cinetown.repository.CityRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);

    public CityServiceImpl(CityRepository cityRepository, CinemaRepository cinemaRepository, ModelMapper modelMapper) {
        this.cityRepository = cityRepository;
        this.cinemaRepository = cinemaRepository;
        this.modelMapper = modelMapper;
    }

    //GET
    @Override
    public ListCinemaDTO getCinemaListByCityName(String cityName) {
        List<CinemaDTO> cinemaDTOList = cityRepository.findById(cityName)
                .map(City::getCinemas)
                .stream()
                .flatMap(Set::stream)
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
   /*     logger.info("Questa e' la mia citta':" + cityName);*/
        Cinema cinema = modelMapper.map(cinemaDTO, Cinema.class);
        Optional<City> optionalCity = cityRepository.findById(cityName);
        City city;

        if (optionalCity.isPresent()) {
            city = optionalCity.get();
        } else {
            city = new City();
            city.setName(cityName);
        }

        //SAve from ManyToOne si puo' evitare doppio set
        cinema.setCity(city);
       /* city.getCinemas().add(cinema);*/

        cinemaRepository.save(cinema);
  /*      cityRepository.save(city);*/
        return cinemaDTO;
    }
}
