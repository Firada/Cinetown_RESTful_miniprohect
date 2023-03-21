package com.execinema.restfulapi_cinetown.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmDTO {

    private String name;
    private String producer;
    private String description;

    @JsonProperty("film_url")
    private String filmUrl;
}
