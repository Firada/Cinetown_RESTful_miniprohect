package com.execinema.restfulapi_cinetown.controller;

import com.execinema.restfulapi_cinetown.api.model.CinemaDTO;
import com.execinema.restfulapi_cinetown.api.model.ListCinemaDTO;
import com.execinema.restfulapi_cinetown.api.model.ListFilmDTO;
import com.execinema.restfulapi_cinetown.service.CityService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(description = "CityController.class")
@RestController
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }


    //GET
    @GetMapping("/city/{cityName}/cinema")
    @ResponseStatus(HttpStatus.OK)
    public ListCinemaDTO getCinemaListByCityName(@PathVariable String cityName){
        return cityService.getCinemaListByCityName(cityName);
    }

    @GetMapping("/city/{cityName}/films")
    @ResponseStatus(HttpStatus.OK)
    public ListFilmDTO getFilmListByCityName(@PathVariable String cityName){
        return cityService.getFilmListByCityName(cityName);
    }

    //POST
    @PostMapping("/city/{cityName}/add/cinema")
    @ResponseStatus(HttpStatus.CREATED)
    public CinemaDTO createNewCinema(@PathVariable String cityName, @RequestBody CinemaDTO cinemaDTO){
        return cityService.createNewCinemaInCity(cityName, cinemaDTO);
    }
}
