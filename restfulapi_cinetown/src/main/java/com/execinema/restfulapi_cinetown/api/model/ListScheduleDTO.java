package com.execinema.restfulapi_cinetown.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListScheduleDTO {

    private List<ScheduleDTO>  scheduleDTOList;
}
