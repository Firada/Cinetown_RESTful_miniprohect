package com.execinema.restfulapi_cinetown.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;


public class CityDTO implements Serializable {


    private static final long serialVersionUID = -7664511165475547596L;
    private String name;

    public CityDTO() {
    }

    public CityDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityDTO cityDTO = (CityDTO) o;

        return Objects.equals(name, cityDTO.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
