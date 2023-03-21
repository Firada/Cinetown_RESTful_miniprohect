package com.execinema.restfulapi_cinetown.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ListCinemaDTO {

    private List<CinemaDTO> cinemaDTOList;

    public ListCinemaDTO(List<CinemaDTO> cinemaDTOList) {
        this.cinemaDTOList = cinemaDTOList;
    }
}
