package com.execinema.restfulapi_cinetown.api.model;

import com.execinema.restfulapi_cinetown.domain.Cinema;
import com.execinema.restfulapi_cinetown.domain.Film;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO implements Serializable {

    private static final long serialVersionUID = -7132319818370112070L;
    private Cinema cinema;
    private Film film;

    /*@JsonProperty("schedule_url")
    private String scheduleUrl;*/
}
