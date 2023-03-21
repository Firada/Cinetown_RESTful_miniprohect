package com.execinema.restfulapi_cinetown.repository;

import com.execinema.restfulapi_cinetown.api.model.CinemaDTO;
import com.execinema.restfulapi_cinetown.domain.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CinemaRepository extends JpaRepository<Cinema, String> {

    Optional<Cinema> findByDistanceFromCityCenter(Double distance);
}
