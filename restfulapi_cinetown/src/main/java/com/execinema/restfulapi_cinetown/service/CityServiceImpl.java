package com.execinema.restfulapi_cinetown.service;

import com.execinema.restfulapi_cinetown.api.mapper.CinemaMapper;
import com.execinema.restfulapi_cinetown.api.mapper.CityMapper;
import com.execinema.restfulapi_cinetown.api.mapper.FilmMapper;
import com.execinema.restfulapi_cinetown.api.mapper.ScheduleMapper;
import com.execinema.restfulapi_cinetown.api.model.*;
import com.execinema.restfulapi_cinetown.domain.Cinema;
import com.execinema.restfulapi_cinetown.domain.City;

import com.execinema.restfulapi_cinetown.domain.Schedule;
import com.execinema.restfulapi_cinetown.repository.CinemaRepository;
import com.execinema.restfulapi_cinetown.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Set;

import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CinemaRepository cinemaRepository;
    private final CityMapper cityMapper;
    private final CinemaMapper cinemaMapper;
    private final ScheduleMapper scheduleMapper;
    private final FilmMapper filmMapper;

    public CityServiceImpl(CityRepository cityRepository, CinemaRepository cinemaRepository,
                           CityMapper cityMapper, CinemaMapper cinemaMapper,
                           ScheduleMapper scheduleMapper, FilmMapper filmMapper) {
        this.cityRepository = cityRepository;
        this.cinemaRepository = cinemaRepository;
        this.cityMapper = cityMapper;
        this.cinemaMapper = cinemaMapper;
        this.scheduleMapper = scheduleMapper;
        this.filmMapper = filmMapper;
    }


    //GET
    @Override
    public ListCinemaDTO getCinemaListByCityName(String cityName) {
        List<CinemaDTO> cinemaDTOList = cityRepository.findById(cityName)
                .get()
                .getCinemas()
                .stream()
                .map(cinema -> {
                    CinemaDTO cinemaDTO = cinemaMapper.cinemaToCinemaDTO(cinema);
                    return cinemaDTO;
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
                    FilmDTO filmDTO = filmMapper.filmToFilmDTO(film);
                    return filmDTO;
                })
                .collect(Collectors.toList());

        return new ListFilmDTO(filmDTOList);
    }

    //POST
    @Override
    public CinemaDTO createNewCinemaInCity(String cityName, Cinema cinema) {

            Cinema newCinema = cinema;
            newCinema.getCity().setName(cityName);
            cinemaRepository.save(newCinema);
            CinemaDTO cinemaDTO = cinemaMapper.cinemaToCinemaDTO(newCinema);

        return cinemaDTO;
    }
}
