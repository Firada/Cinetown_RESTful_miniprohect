package com.execinema.restfulapi_cinetown.repository;

import com.execinema.restfulapi_cinetown.domain.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CinemaRepository extends JpaRepository<Cinema, String> {

    //cerco subito per citta' e distanza
    List<Cinema> findByCityNameAndDistanceFromCityCenterIsLessThanEqual(String cityName, Double distance);
    Optional<Cinema> findByCityName(String cityName);
}
