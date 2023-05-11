package com.execinema.restfulapi_cinetown.controller;

import com.execinema.restfulapi_cinetown.api.model.FilmDTO;
import com.execinema.restfulapi_cinetown.api.model.ListFilmDTO;
import com.execinema.restfulapi_cinetown.domain.Film;
import com.execinema.restfulapi_cinetown.domain.FilmId;
import com.execinema.restfulapi_cinetown.exception.ResourceNotFoundException;
import com.execinema.restfulapi_cinetown.service.CinemaService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import java.util.ArrayList;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class CinemaControllerTest {


    CinemaController cinemaController;

    @Mock
    CinemaService cinemaService;

    /*Se non uso @Mock, creo cosi' il mock di una classe*/
    /*CinemaService cinemaService = mock(CinemaService.class);*/

    MockMvc mockMvc;

    String cityName;
    String cinemaName;
    String filmName;
    String producer;
    String description;
    FilmId filmId;
    Film film;
    FilmDTO filmDTO;
    ListFilmDTO listFilmDTO;


    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        cinemaController = new CinemaController(cinemaService);

        mockMvc = MockMvcBuilders.standaloneSetup(cinemaController).build();

        cityName = "cityName";
        filmName = "filmName";
        cinemaName = "cinemaName";
        producer = "producerName";
        description = "nice description";

        filmId = new FilmId(filmName, producer);
        film = new Film(filmName, producer);
        film.setDescription(description);

        filmDTO = new FilmDTO(filmName, producer, description);

        listFilmDTO = new ListFilmDTO();
        listFilmDTO.setFilmDTOList(new ArrayList<>());
        listFilmDTO.getFilmDTOList().add(filmDTO);
    }

    @Test
    public void getFilmListByCinemaName() throws Exception {
       /* when(cinemaService.getFilmListByCinemaName(cinemaName)).thenReturn(listFilmDTO);*/
        /*ListFilmDTO expectedList = cinemaController.getFilmListByCinemaName(cinemaName);*/
       /* assertEquals(1, listFilmDTO.getFilmDTOList().size());*/
      /*  assertEquals(listFilmDTO, expectedList);*/

        mockMvc.perform(get("/cinema/cinemaName/films")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getCinemaListByCityNameFilmNameProducerAndDistance() throws Exception {

        mockMvc.perform(get("/cinema/all/city/{cityName}/film/{filmName}/producer/{producer}", cityName, filmName, producer)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test/*(expected = ResourceNotFoundException.class)*/
    public void deleteCinemaByName() throws Exception {

        mockMvc.perform(delete("/cinema/cinemaName")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test(expected = NestedServletException.class)
    public void deleteCinemaByName_cinemaNotinDB() throws Exception {

        doThrow(new ResourceNotFoundException()).when(cinemaService).deleteCinemaByName(cinemaName);
        mockMvc.perform(delete("/cinema/cinemaName")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}