package com.execinema.restfulapi_cinetown.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CinemaDTO {

    private String name;
    private String address;
    private Double distanceFromCityCenter;

    @JsonProperty("cinema_url")
    private String cinemaUrl;

}
