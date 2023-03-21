package com.execinema.restfulapi_cinetown.controller;

import com.execinema.restfulapi_cinetown.domain.Schedule;
import com.execinema.restfulapi_cinetown.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    //PUT
    @PutMapping("/schedule")
    @ResponseStatus(HttpStatus.OK)
    public void updateSchedule(Long id, Schedule schedule){
        scheduleService.updateSchedule(id, schedule);
    }
}
