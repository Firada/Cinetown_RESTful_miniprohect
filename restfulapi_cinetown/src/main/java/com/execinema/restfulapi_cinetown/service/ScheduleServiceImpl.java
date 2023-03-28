package com.execinema.restfulapi_cinetown.service;


import com.execinema.restfulapi_cinetown.api.model.SchedulePutDTO;
import com.execinema.restfulapi_cinetown.domain.Cinema;
import com.execinema.restfulapi_cinetown.domain.Film;
import com.execinema.restfulapi_cinetown.domain.FilmId;
import com.execinema.restfulapi_cinetown.domain.Schedule;
import com.execinema.restfulapi_cinetown.exception.ResourceNotFoundException;
import com.execinema.restfulapi_cinetown.repository.CinemaRepository;
import com.execinema.restfulapi_cinetown.repository.FilmRepository;
import com.execinema.restfulapi_cinetown.repository.ScheduleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
            throw new ResourceNotFoundException("Cinema name field: " + schedulePutDTO.getCinema_name() + " doesn't exists");
        }

        Optional<Film> optFilm = filmRepository.findById(new FilmId
                (schedulePutDTO.getFilm_name(), schedulePutDTO.getFilm_producer()));

        if (optFilm.isEmpty()) {
           /* log.error("Film non trovato");*/
            throw new ResourceNotFoundException("Film name and/or film producer not found");
        }

        Optional<Schedule> schedules = scheduleRepository.findByCinemaAndFilm(optCinema.get(), optFilm.get());
        Schedule schedule;
        if (schedules.isEmpty()) {
            schedule = new Schedule();
            schedule.setCinema(optCinema.get());
            schedule.setFilm(optFilm.get());
            schedulePutDTO.setMessage("New schedule created");

        } else {
            schedule = schedules.get();
            schedulePutDTO.setMessage("Updated schedule");
        }
        scheduleRepository.save(schedule);

        //Come mai non uso la mappatura?????

        return schedulePutDTO;
    }


    @Override
    public String updateScheduleWithMessage(SchedulePutDTO schedulePutDTO) {

        /*  log.info(schedulePutDTO.toString());*/
        Optional<Cinema> optCinema = cinemaRepository.findById(schedulePutDTO.getCinema_name());

        if (optCinema.isEmpty()) {
            /*  log.error("Cinema non trovato");*/
            throw new ResourceNotFoundException("Cinema name field: " + schedulePutDTO.getCinema_name() + " doesn't exists");
        }

        Optional<Film> optFilm = filmRepository.findById(new FilmId
                (schedulePutDTO.getFilm_name(), schedulePutDTO.getFilm_producer()));

        if (optFilm.isEmpty()) {
            /* log.error("Film non trovato");*/
            throw new ResourceNotFoundException("Film name and/or film producer not found");
        }

        Optional<Schedule> schedules = scheduleRepository.findByCinemaAndFilm(optCinema.get(), optFilm.get());

        if (schedules.isEmpty()) {
            Schedule schedule = new Schedule();
            schedule.setCinema(optCinema.get());
            schedule.setFilm(optFilm.get());
            scheduleRepository.save(schedule);
        }

        return "Sono un mex custom by String";
        /*return new CustomMessageDTO("Sono un messaggio custom");*/
    }
}
