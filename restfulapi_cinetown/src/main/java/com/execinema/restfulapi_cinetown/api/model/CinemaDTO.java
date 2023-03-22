package com.execinema.restfulapi_cinetown.api.model;



import java.io.Serializable;
import java.util.Objects;


public class CinemaDTO implements Serializable {

    private static final long serialVersionUID = 4267568269455581829L;

    private String name;
    private String address;
    private Double distanceFromCityCenter;

    public CinemaDTO() {
    }

    public CinemaDTO(String name, String address, Double distanceFromCityCenter) {
        this.name = name;
        this.address = address;
        this.distanceFromCityCenter = distanceFromCityCenter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getDistanceFromCityCenter() {
        return distanceFromCityCenter;
    }

    public void setDistanceFromCityCenter(Double distanceFromCityCenter) {
        this.distanceFromCityCenter = distanceFromCityCenter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CinemaDTO cinemaDTO = (CinemaDTO) o;

        return Objects.equals(name, cinemaDTO.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CinemaDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", distanceFromCityCenter=" + distanceFromCityCenter +
                '}';
    }
}
