package com.execinema.restfulapi_cinetown.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
/*@Embeddable*/
public class FilmId implements Serializable {

    private String name;
    private String producer;

    public FilmId(String name, String producer) {
        this.name = name;
        this.producer = producer;
    }
}
