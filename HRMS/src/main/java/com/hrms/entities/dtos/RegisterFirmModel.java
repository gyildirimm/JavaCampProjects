package com.hrms.entities.dtos;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterFirmModel {
    @NotNull
    private String firmName;

    @NotNull
    private Date createDate;

    @NotNull
    private String email;

    @NotNull
    private String tc;

    @NotNull
    private String phone;

    @NotNull
    private String password;

    @NotNull
    private String passwordRepeat;
}
