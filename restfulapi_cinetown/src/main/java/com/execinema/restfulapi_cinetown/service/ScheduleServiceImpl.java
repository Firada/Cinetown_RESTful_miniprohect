package com.execinema.restfulapi_cinetown.service;


import com.execinema.restfulapi_cinetown.api.model.ScheduleDTO;
import com.execinema.restfulapi_cinetown.api.model.SchedulePutDTO;
import com.execinema.restfulapi_cinetown.domain.Cinema;
import com.execinema.restfulapi_cinetown.domain.Film;
import com.execinema.restfulapi_cinetown.domain.FilmId;
import com.execinema.restfulapi_cinetown.domain.Schedule;
import com.execinema.restfulapi_cinetown.exception.ResourceNotFoundException;
import com.execinema.restfulapi_cinetown.repository.CinemaRepository;
import com.execinema.restfulapi_cinetown.repository.FilmRepository;
import com.execinema.restfulapi_cinetown.repository.ScheduleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final FilmRepository filmRepository;
    private final CinemaRepository cinemaRepository;
    private final ModelMapper modelMapper;

    /* private Logger log = LoggerFactory.getLogger(ScheduleServiceImpl.class);*/

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository, FilmRepository filmRepository,
                               CinemaRepository cinemaRepository, ModelMapper modelMapper) {
        this.scheduleRepository = scheduleRepository;
        this.filmRepository = filmRepository;
        this.cinemaRepository = cinemaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SchedulePutDTO updateSchedule(SchedulePutDTO schedulePutDTO) {

      /*  log.info(schedulePutDTO.toString());*/
        Optional<Cinema> optCinema = cinemaRepository.findById(schedulePutDTO.getCinema_name());

        if (optCinema.isEmpty()) {
          /*  log.error("Cinema non trovato");*/
            throw new ResourceNotFoundException();
        }

        Optional<Film> optFilm = filmRepository.findById(new FilmId
                (schedulePutDTO.getFilm_name(), schedulePutDTO.getFilm_producer()));

        if (optFilm.isEmpty()) {
           /* log.error("Film non trovato");*/
            throw new ResourceNotFoundException();
        }

        Set<Schedule> schedules = scheduleRepository.findByCinemaAndFilm(optCinema.get(), optFilm.get());

        if (schedules.isEmpty()) {
            Schedule schedule = new Schedule();
            schedule.setCinema(optCinema.get());
            schedule.setFilm(optFilm.get());
            scheduleRepository.save(schedule);
        }

        return schedulePutDTO;
    }
}
