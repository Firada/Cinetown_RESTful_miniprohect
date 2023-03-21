package com.execinema.restfulapi_cinetown.api.mapper;

import com.execinema.restfulapi_cinetown.api.model.CityDTO;
import com.execinema.restfulapi_cinetown.domain.City;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityMapper {

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);
    CityDTO cityToCityDTO (City city);
    City cityDTOToCity(CityDTO cityDTO);
}
