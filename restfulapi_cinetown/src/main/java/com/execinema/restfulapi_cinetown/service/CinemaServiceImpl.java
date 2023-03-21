package com.execinema.restfulapi_cinetown.service;

import com.execinema.restfulapi_cinetown.api.mapper.CinemaMapper;
import com.execinema.restfulapi_cinetown.api.mapper.FilmMapper;
import com.execinema.restfulapi_cinetown.api.model.CinemaDTO;
import com.execinema.restfulapi_cinetown.api.model.FilmDTO;
import com.execinema.restfulapi_cinetown.api.model.ListCinemaDTO;
import com.execinema.restfulapi_cinetown.api.model.ListFilmDTO;
import com.execinema.restfulapi_cinetown.domain.Cinema;
import com.execinema.restfulapi_cinetown.domain.City;
import com.execinema.restfulapi_cinetown.domain.Schedule;
import com.execinema.restfulapi_cinetown.repository.CinemaRepository;
import com.execinema.restfulapi_cinetown.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CinemaServiceImpl implements CinemaService{

    private final CinemaRepository cinemaRepository;
    private final FilmMapper filmMapper;
    private final CinemaMapper cinemaMapper;

    public CinemaServiceImpl(CinemaRepository cinemaRepository, FilmMapper filmMapper, CinemaMapper cinemaMapper) {
        this.cinemaRepository = cinemaRepository;
        this.filmMapper = filmMapper;
        this.cinemaMapper = cinemaMapper;
    }

    @Override
    public ListFilmDTO getFilmListByCinemaName(String cinemaName) {
        List<FilmDTO> filmDTOList = cinemaRepository.findById(cinemaName)
                .map(Cinema::getSchedules)
                .stream()
                .flatMap(Set::stream)
                .map(Schedule::getFilm)
                .map(film -> {
                    FilmDTO filmDTO = filmMapper.filmToFilmDTO(film);
                    return filmDTO;
                })
                .collect(Collectors.toList());
        return new ListFilmDTO(filmDTOList);
    }

    //Da ordinare dal meno distante al piu distante
    @Override
    public ListCinemaDTO getCinemaListByCityNameFilmNameAndProducer( String cityName,
                                                                     String filmName,
                                                                     String producer){
        List<CinemaDTO> cinemaDTOList = cinemaRepository.findAll()
                .stream()
                .map(cinema -> {
                    cinema.getCity().setName(cityName);
                    cinema.getSchedules()
                            .stream()
                            .map(schedule -> {
                                schedule.getFilm().setName(filmName);
                                schedule.getFilm().setProducer(producer);
                                return schedule;
                            })
                            .collect(Collectors.toList());
                    CinemaDTO cinemaDTO = cinemaMapper.cinemaToCinemaDTO(cinema);
                    return cinemaDTO;
                })
                .collect(Collectors.toList());

        //TO ORDER
        /*cinemaDTOList.stream()
                .sorted((o1, o2) -> {
                    o1.getDistanceFromCityCenter().compareTo(o2.getDistanceFromCityCenter());
                    return cinemaDTOList;
                })
                .collect(Collectors.toList());*/

    /*  Collections.sort(cinemaDTOList, new Comparator<CinemaDTO>() {
            @Override
            public double compare(CinemaDTO o1, CinemaDTO o2) {
                return o1.getDistanceFromCityCenter().compareTo(o2.getDistanceFromCityCenter());
            }
        });*/

/*        cinemaDTOList.stream()
                .sorted(Comparator.comparing(CinemaDTO::getDistanceFromCityCenter))
                .collect(Collectors.toList());*/

        return new ListCinemaDTO(cinemaDTOList);
    }

    @Override
    public ListCinemaDTO getCinemaListByCityNameFilmNameProducerAndDistance(String cityName,
                                                                            String filmName,
                                                                            String producer,
                                                                            Double distance) {
        List<CinemaDTO> cinemaDTOList = cinemaRepository.findByDistanceFromCityCenter(distance)
                .stream()
                .map(cinema -> {
                    cinema.getCity().setName(cityName);
                    cinema.getSchedules()
                            .stream()
                            .map(schedule -> {
                                schedule.getFilm().setName(filmName);
                                schedule.getFilm().setProducer(producer);
                                return schedule;
                            })
                            .collect(Collectors.toList());
                    CinemaDTO cinemaDTO = cinemaMapper.cinemaToCinemaDTO(cinema);
                    return cinemaDTO;
                })
                .collect(Collectors.toList());
        return new ListCinemaDTO(cinemaDTOList);
    }


    @Override
    public void deleteCinemaByName(String cinemaName) {
        if(cinemaRepository.findById(cinemaName) != null){
            cinemaRepository.deleteById(cinemaName);
        }

    }


}
