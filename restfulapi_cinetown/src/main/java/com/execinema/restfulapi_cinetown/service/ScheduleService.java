package com.execinema.restfulapi_cinetown.service;

import com.execinema.restfulapi_cinetown.api.model.SchedulePutDTO;

public interface ScheduleService {

  SchedulePutDTO updateSchedule(SchedulePutDTO schedulePutDTO);
/*  CustomMessageDTO updateScheduleWithMessage(SchedulePutDTO schedulePutDTO);*/
  String updateScheduleWithMessage(SchedulePutDTO schedulePutDTO);

}
