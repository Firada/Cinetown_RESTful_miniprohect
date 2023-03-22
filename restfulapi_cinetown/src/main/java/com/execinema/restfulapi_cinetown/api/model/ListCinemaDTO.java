package com.execinema.restfulapi_cinetown.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class ListCinemaDTO implements Serializable {

    private static final long serialVersionUID = -8898594000229890049L;
    private List<CinemaDTO> cinemaDTOList;

    public ListCinemaDTO(List<CinemaDTO> cinemaDTOList) {
        this.cinemaDTOList = cinemaDTOList;
    }
}
