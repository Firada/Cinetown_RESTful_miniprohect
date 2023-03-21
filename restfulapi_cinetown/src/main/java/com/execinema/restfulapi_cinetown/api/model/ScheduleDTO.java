package com.execinema.restfulapi_cinetown.api.model;

import com.execinema.restfulapi_cinetown.domain.Cinema;
import com.execinema.restfulapi_cinetown.domain.Film;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {

    private Cinema cinema;
    private Film film;

    @JsonProperty("schedule_url")
    private String scheduleUrl;

}
