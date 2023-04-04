package com.execinema.restfulapi_cinetown.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class FilmDTO implements Serializable {

    private static final long serialVersionUID = -6504237329788313894L;

    @ApiModelProperty(value = "Composite primary key with 'producer'", required = true)
 /*   @NotNull(message = "name cannot be null")*/
    @NotBlank(message = "name can't be blank")
    private String name;

    @ApiModelProperty(value = "Composite primary key with 'name'", required = true)
    @NotNull(message = "producer can not be null")
    private String producer;

    @ApiModelProperty(value = "The film description")
    private String description;

    public FilmDTO() {
    }
}
