package com.execinema.restfulapi_cinetown.controller;

import com.execinema.restfulapi_cinetown.api.model.ScheduleDTO;
import com.execinema.restfulapi_cinetown.api.model.SchedulePutDTO;
import com.execinema.restfulapi_cinetown.domain.Schedule;
import com.execinema.restfulapi_cinetown.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    //PUT
    @PutMapping("/schedule")
    @ResponseStatus(HttpStatus.OK)
    public SchedulePutDTO updateSchedule(@RequestBody SchedulePutDTO schedulePutDTO){
        return scheduleService.updateSchedule(schedulePutDTO);
    }
}
