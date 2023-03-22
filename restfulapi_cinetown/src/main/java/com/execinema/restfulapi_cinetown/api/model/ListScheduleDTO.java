package com.execinema.restfulapi_cinetown.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListScheduleDTO implements Serializable {

    private static final long serialVersionUID = 8857970110196301348L;
    private List<ScheduleDTO>  scheduleDTOList;
}
