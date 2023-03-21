package com.execinema.restfulapi_cinetown.service;

import com.execinema.restfulapi_cinetown.api.mapper.ScheduleMapper;
import com.execinema.restfulapi_cinetown.api.model.ScheduleDTO;
import com.execinema.restfulapi_cinetown.domain.Schedule;
import com.execinema.restfulapi_cinetown.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository, ScheduleMapper scheduleMapper) {
        this.scheduleRepository = scheduleRepository;
        this.scheduleMapper = scheduleMapper;
    }


    @Override
    public ScheduleDTO updateSchedule(Long id, Schedule schedule) {
        scheduleRepository.findById(id);
        Schedule newSchedule = scheduleRepository.save(schedule);
        ScheduleDTO scheduleDTO = scheduleMapper.scheduleToScheduleDto(newSchedule);
        return scheduleDTO;
    }
}
