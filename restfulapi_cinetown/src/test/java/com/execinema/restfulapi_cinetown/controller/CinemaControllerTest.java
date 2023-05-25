package com.execinema.restfulapi_cinetown.controller;

import com.execinema.restfulapi_cinetown.api.model.CinemaDTO;
import com.execinema.restfulapi_cinetown.api.model.FilmDTO;
import com.execinema.restfulapi_cinetown.api.model.ListCinemaDTO;
import com.execinema.restfulapi_cinetown.api.model.ListFilmDTO;
import com.execinema.restfulapi_cinetown.domain.Film;
import com.execinema.restfulapi_cinetown.domain.FilmId;
import com.execinema.restfulapi_cinetown.service.CinemaService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class CinemaControllerTest {

    @InjectMocks
    private CinemaController cinemaController;

    @Mock
    private CinemaService cinemaService;

    /*Se non uso @Mock, creo cosi' il mock di una classe*/
    /*CinemaService cinemaService = mock(CinemaService.class);*/

    private MockMvc mockMvc;

    private final String CITY_NAME = "cityName" ;
    private final String CINEMA_NAME = "cinemaName";
    private final String FILM_NAME = "filmName";
    private final String PRODUCER = "producer";
    private final Double DISTANCE = 0.0;
    private final String DESCRIPTION = "description";

    @Mock
    private FilmId filmId;
    @Mock
    private Film film;
    @Mock
    private FilmDTO filmDTO;

    ListFilmDTO listFilmDTO = new ListFilmDTO();
    ListCinemaDTO listCinemaDTO = new ListCinemaDTO();
    List<CinemaDTO> cinemaDTO = new ArrayList<>();
    private CinemaDTO cinemaDTOobj;





    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(cinemaController).build();
        cinemaDTO.add(cinemaDTOobj);
        listCinemaDTO.setCinemaDTOList(cinemaDTO);
    }

    @Test
    public void getFilmListByCinemaName() throws Exception {
       /* when(cinemaService.getFilmListByCinemaName(cinemaName)).thenReturn(listFilmDTO);*/
        /*ListFilmDTO expectedList = cinemaController.getFilmListByCinemaName(cinemaName);*/
       /* assertEquals(1, listFilmDTO.getFilmDTOList().size());*/
      /*  assertEquals(listFilmDTO, expectedList);*/

        when(cinemaService.getFilmListByCinemaName(CINEMA_NAME)).thenReturn(listFilmDTO);
        mockMvc.perform(get("/cinema/cinemaName/films")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getCinemaListByCityNameFilmNameProducerAndDistance() throws Exception {
        when(cinemaService.getCinemaListByCityNameFilmNameProducerAndDistance(CITY_NAME, FILM_NAME, PRODUCER, DISTANCE)).thenReturn(listCinemaDTO);
        mockMvc.perform(get("/cinema/all/city/{cityName}/film/{filmName}/producer/{producer}?distance={distance}", CITY_NAME, FILM_NAME, PRODUCER, DISTANCE)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cinemaDTOList", hasSize(1)));
    }

    @Test/*(expected = ResourceNotFoundException.class)*/
    public void deleteCinemaByName() throws Exception {

        doNothing().when(cinemaService).deleteCinemaByName(CINEMA_NAME);

        mockMvc.perform(delete("/cinema/cinemaName")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(cinemaService, times(1)).deleteCinemaByName(CINEMA_NAME);
    }

    @Test(expected = NestedServletException.class)
    public void deleteCinemaByName_cinemaNotinDB() throws Exception {
/*
        doThrow(new ResourceNotFoundException()).when(cinemaService).deleteCinemaByName(CINEMA_NAME);
        mockMvc.perform(delete("/cinema/cinemaName")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());*/
    }
}