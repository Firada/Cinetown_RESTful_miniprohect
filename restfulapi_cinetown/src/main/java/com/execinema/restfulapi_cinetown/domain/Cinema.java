package com.execinema.restfulapi_cinetown.domain;

import javax.persistence.*;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class Cinema {

    @Id
    private String name;

    private String address;
    private Double distanceFromCityCenter;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cityName", nullable = false)
    private City city;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cinema")
    private Set<Schedule> schedules = new HashSet<>();

    public Cinema() {
    }

    public Cinema(String name) {
        this.name = name;
    }

    public Cinema(String name, String address, Double distanceFromCityCenter) {
        this.name = name;
        this.address = address;
        this.distanceFromCityCenter = distanceFromCityCenter;
    }

    public Cinema(String name, String address, Double distanceFromCityCenter, City city, Set<Schedule> schedules) {
        this.name = name;
        this.address = address;
        this.distanceFromCityCenter = distanceFromCityCenter;
        this.city = city;
        this.schedules = schedules;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cinema cinema = (Cinema) o;

        return Objects.equals(name, cinema.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", distanceFromCityCenter=" + distanceFromCityCenter +
                ", city=" + city +
                ", schedules=" + schedules +
                '}';
    }
}
