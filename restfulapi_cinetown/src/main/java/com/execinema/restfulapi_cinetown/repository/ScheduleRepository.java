package com.execinema.restfulapi_cinetown.repository;

import com.execinema.restfulapi_cinetown.domain.Cinema;
import com.execinema.restfulapi_cinetown.domain.Film;
import com.execinema.restfulapi_cinetown.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    Set<Schedule> findByCinemaAndFilm(Cinema cinema, Film film);
}
