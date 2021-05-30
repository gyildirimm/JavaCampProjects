package com.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDetailModel {
    private String firmName;
    private String jobName;
    private int jobCount;
    private Date startDate;
    private Date endDate;
}
