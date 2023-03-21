package com.execinema.restfulapi_cinetown.api.mapper;

import com.execinema.restfulapi_cinetown.api.model.FilmDTO;
import com.execinema.restfulapi_cinetown.domain.Film;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FilmMapper {

    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);
    FilmDTO filmToFilmDTO(Film film);
    Film filmDTOToFilm(FilmDTO filmDTO);
}
