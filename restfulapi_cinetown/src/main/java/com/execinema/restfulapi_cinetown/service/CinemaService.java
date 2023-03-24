package com.execinema.restfulapi_cinetown.service;

import com.execinema.restfulapi_cinetown.api.model.CinemaDTO;
import com.execinema.restfulapi_cinetown.api.model.ListCinemaDTO;
import com.execinema.restfulapi_cinetown.api.model.ListFilmDTO;
import com.execinema.restfulapi_cinetown.domain.Cinema;

import java.util.List;

public interface CinemaService {

   //GET
   ListFilmDTO getFilmListByCinemaName(String cinemaName);
/*   ListCinemaDTO getCinemaListByCityNameFilmNameAndProducer(String cityName, String filmName, String producer);*/
   ListCinemaDTO getCinemaListByCityNameFilmNameProducerAndDistance(String cityName, String filmName, String producer, Double distance);

   //DELETE
   void deleteCinemaByName(String cinemaName);


}
