package com.execinema.restfulapi_cinetown.domain;

import javax.persistence.*;;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;


public class FilmId implements Serializable {

    private String name;
    private String producer;

    public FilmId(String name, String producer) {
        this.name = name;
        this.producer = producer;
    }

    public FilmId() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmId filmId = (FilmId) o;

        if (!Objects.equals(name, filmId.name)) return false;
        return Objects.equals(producer, filmId.producer);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FilmId{" +
                "name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
