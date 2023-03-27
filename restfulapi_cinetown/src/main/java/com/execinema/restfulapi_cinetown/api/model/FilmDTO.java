package com.execinema.restfulapi_cinetown.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class FilmDTO implements Serializable {

    private static final long serialVersionUID = -6504237329788313894L;

    @ApiModelProperty(value = "name = FilmId.class - name", required = true)
    private String name;

    @ApiModelProperty(required = true)
    private String producer;

    @ApiModelProperty(value = "The film description")
    private String description;

    public FilmDTO() {
    }




    /*  @JsonProperty("film_url")
    private String filmUrl;*/
}
