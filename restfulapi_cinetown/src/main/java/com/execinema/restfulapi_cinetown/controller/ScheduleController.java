package com.execinema.restfulapi_cinetown.controller;

import com.execinema.restfulapi_cinetown.api.model.SchedulePutDTO;
import com.execinema.restfulapi_cinetown.service.ScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "ScheduleController.class")
@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    //PUT
    @ApiOperation(value = "Creates a new schedule if it doesn't exists yet, and add it to a cinema with a film", notes = "About the API...")
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

    @ApiOperation(value = "Testing a message on Postman",
            notes = "This request works exactly like the other above. \n It's just a test to send a 'response message' in different ways")

    @PutMapping("/schedule/message")
    @ResponseStatus(HttpStatus.OK)
    public String updateScheduleWithMessage(@RequestBody SchedulePutDTO schedulePutDTO){
        return scheduleService.updateScheduleWithMessage(schedulePutDTO);
    }

}
