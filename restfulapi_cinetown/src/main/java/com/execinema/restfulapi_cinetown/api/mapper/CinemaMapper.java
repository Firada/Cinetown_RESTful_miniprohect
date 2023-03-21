package com.execinema.restfulapi_cinetown.api.mapper;

import com.execinema.restfulapi_cinetown.api.model.CinemaDTO;
import com.execinema.restfulapi_cinetown.domain.Cinema;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CinemaMapper {

    CinemaMapper INSTANCE = Mappers.getMapper(CinemaMapper.class);
    CinemaDTO cinemaToCinemaDTO(Cinema cinema);
    Cinema cinemaDTOToCinema(CinemaDTO cinemaDTO);
}
