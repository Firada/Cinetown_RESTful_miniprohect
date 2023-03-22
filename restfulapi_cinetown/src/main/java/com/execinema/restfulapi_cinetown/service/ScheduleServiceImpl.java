package com.execinema.restfulapi_cinetown.service;


import com.execinema.restfulapi_cinetown.api.model.ScheduleDTO;
import com.execinema.restfulapi_cinetown.domain.Schedule;
import com.execinema.restfulapi_cinetown.repository.ScheduleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;
    private final ModelMapper modelMapper;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository, ModelMapper modelMapper) {
        this.scheduleRepository = scheduleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ScheduleDTO updateSchedule(Long id, Schedule schedule) {
        scheduleRepository.findById(id);
        Schedule newSchedule = scheduleRepository.save(schedule);
        ScheduleDTO scheduleDTO = modelMapper.map(schedule, ScheduleDTO.class);
        return scheduleDTO;
    }
}
