package com.execinema.restfulapi_cinetown.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCityDTO implements Serializable {

    private static final long serialVersionUID = -1636274691184816221L;
    private List<CityDTO> cityDTOList;
}
