package com.execinema.restfulapi_cinetown.service;

import com.execinema.restfulapi_cinetown.api.model.CinemaDTO;
import com.execinema.restfulapi_cinetown.api.model.ScheduleDTO;
import com.execinema.restfulapi_cinetown.domain.Cinema;
import com.execinema.restfulapi_cinetown.domain.Schedule;

public interface ScheduleService {

  ScheduleDTO updateSchedule(Long id, Schedule schedule);
}
