package com.execinema.restfulapi_cinetown.controller;

import com.execinema.restfulapi_cinetown.api.model.SchedulePutDTO;
import com.execinema.restfulapi_cinetown.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public SchedulePutDTO updateSchedule(@RequestBody SchedulePutDTO schedulePutDTO){
        return scheduleService.updateSchedule(schedulePutDTO);
    }

    //Testing a custom messagge
 /*   @PutMapping("/schedule/message")
    @ResponseStatus(HttpStatus.OK)
    public CustomMessageDTO updateScheduleWithMessage(@RequestBody SchedulePutDTO schedulePutDTO){
        return scheduleService.updateScheduleWithMessage(schedulePutDTO);
    }*/

    @PutMapping("/schedule/message")
    @ResponseStatus(HttpStatus.OK)
    public String updateScheduleWithMessage(@RequestBody SchedulePutDTO schedulePutDTO){
        return scheduleService.updateScheduleWithMessage(schedulePutDTO);
    }

}
