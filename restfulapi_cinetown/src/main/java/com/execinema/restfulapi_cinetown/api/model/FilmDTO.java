package com.execinema.restfulapi_cinetown.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class FilmDTO implements Serializable {

    private static final long serialVersionUID = -6504237329788313894L;
    private String name;
    private String producer;
    private String description;

    public FilmDTO() {
    }




    /*  @JsonProperty("film_url")
    private String filmUrl;*/
}
