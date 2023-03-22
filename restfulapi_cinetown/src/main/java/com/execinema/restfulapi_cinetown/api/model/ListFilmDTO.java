package com.execinema.restfulapi_cinetown.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class ListFilmDTO implements Serializable {

    private static final long serialVersionUID = -740489623651142239L;
    private List<FilmDTO> filmDTOList;

    public ListFilmDTO(List<FilmDTO> filmDTOList) {
        this.filmDTOList = filmDTOList;
    }
}
