package com.execinema.restfulapi_cinetown.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {

    private String name;

    @JsonProperty("city_url")
    private String cityUrl;
}
