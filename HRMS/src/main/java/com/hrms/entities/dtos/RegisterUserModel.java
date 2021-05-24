package com.hrms.entities.dtos;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserModel {
    @NotNull
    private String firstName;

    @NotNull
    private String secondName;

    @NotNull
    private Date birthDate;

    @NotNull
    private String email;

    @NotNull
    private String tc;

    @NotNull
    private String password;

    @NotNull
    private String passwordRepeat;

    @NotNull
    private List<Integer> userJobId;
}
