package com.execinema.restfulapi_cinetown.api.mapper;

import com.execinema.restfulapi_cinetown.api.model.ScheduleDTO;
import com.execinema.restfulapi_cinetown.domain.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScheduleMapper {

    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);
    ScheduleDTO scheduleToScheduleDto (Schedule schedule);
    Schedule scheduleDtoToSchedule (ScheduleDTO scheduleDTO);


}
