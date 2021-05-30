package com.hrms.entities.dtos;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddFirmJobModel {
    @NotNull
    private String explanation;

    private double priceMin;
    private double priceMax;

    @NotNull
    private int jobCount;
    private Date startDate;

    @NotNull
    private Date endDate;
    private boolean isActive;

    @NotNull
    private int firmId;

    @NotNull
    private int jobId;

    @NotNull
    private int provinceId;
}
