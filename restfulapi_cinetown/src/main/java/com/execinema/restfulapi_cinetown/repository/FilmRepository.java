package com.execinema.restfulapi_cinetown.repository;

import com.execinema.restfulapi_cinetown.domain.Film;
import com.execinema.restfulapi_cinetown.domain.FilmId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, FilmId> {

    //DELETE
    void deleteAllByName(String name);
}
