package com.execinema.restfulapi_cinetown.repository;

import com.execinema.restfulapi_cinetown.domain.Film;
import com.execinema.restfulapi_cinetown.domain.FilmId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
class FilmRepositoryTest {

    @Autowired
    FilmRepository filmRepository;

    Film film;
    Film film1;
    Film film2;

    @BeforeEach
    public void setUp() {
        film = new Film("Fantasia", "Disney");
        filmRepository.save(film);
        film1 = new Film("Fantasia", "DisneyPlus");
        filmRepository.save(film1);
        film2 = new Film("Fantasia mix", "THIS-ney");
        filmRepository.save(film2);
    }

    @Test
    void testFilmRepositoryCount() {
        Film film1 = filmRepository.save(new Film("Cenerentola", "Disney"));
        System.out.println(filmRepository.findAll());
        assertEquals(4, filmRepository.count());
    }

    @Test
    void testFilmRepositorySize() {

        //assertNotEquals()
        Film film1 = filmRepository.save(new Film("Cenerentola", "Disney"));
        assertNotEquals(4, filmRepository.findAll().size());

        //assertEquals
        assertEquals(4, filmRepository.findAll().size());
    }

    @Test
    void testFilmRepositorySave() {
      /*  FilmId filmId = new FilmId("Film random", "Random producer");
        Film film1 = new Film();
        film1.setProducer("Random producer");
        film1.setName("Film random");
        filmRepository.save(film1);
        assertEquals(film1, filmRepository.findById(filmId).get());*/
        /* assertEquals(1, filmRepository.count());*/

        assertEquals(film, filmRepository.findById(new FilmId(film.getName(), film.getProducer())).get());
    }

    @Test
    void testFilmRepositoryDeleteById() {
        filmRepository.deleteById(new FilmId(film.getName(), film.getProducer()));
        assertEquals(0, filmRepository.findAll().size());
    }

    @Test
    void testDeleteAllByName() {
        filmRepository.deleteAllByName("Fantasia");
        assertEquals(0, filmRepository.findAll().size());
    }
}