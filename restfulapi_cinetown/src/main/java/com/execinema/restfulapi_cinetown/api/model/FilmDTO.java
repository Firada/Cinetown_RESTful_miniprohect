package com.execinema.restfulapi_cinetown.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class FilmDTO implements Serializable {

    private static final long serialVersionUID = -6504237329788313894L;

    @ApiModelProperty(value = "Composite primary key with 'producer'", required = true)
    private String name;

    @ApiModelProperty(value = "Composite primary key with 'name'", required = true)
    private String producer;

    @ApiModelProperty(value = "The film description")
    private String description;

    public FilmDTO() {
    }
}
