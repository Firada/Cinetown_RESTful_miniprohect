package com.execinema.restfulapi_cinetown.service;


import com.execinema.restfulapi_cinetown.api.model.CinemaDTO;
import com.execinema.restfulapi_cinetown.api.model.ListCinemaDTO;
import com.execinema.restfulapi_cinetown.api.model.ListFilmDTO;
import com.execinema.restfulapi_cinetown.domain.Cinema;

import java.util.List;

public interface CityService {

    //GET
    ListCinemaDTO getCinemaListByCityName(String cityName);
    ListFilmDTO getFilmListByCityName(String cityName);

    //POST
    CinemaDTO createNewCinemaInCity(String cityName, CinemaDTO cinemaDTO);
}
