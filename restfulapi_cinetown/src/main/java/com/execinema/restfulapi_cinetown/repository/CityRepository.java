package com.execinema.restfulapi_cinetown.repository;

import com.execinema.restfulapi_cinetown.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, String> {
}
