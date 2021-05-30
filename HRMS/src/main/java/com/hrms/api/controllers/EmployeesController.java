package com.hrms.api.controllers;

import com.hrms.business.abstracts.UserJobService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.entities.concretes.UserJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    @Autowired
    private UserJobService _userJobService;

    @GetMapping("/getAll")
    public DataResult<List<UserJob>> getAll(){
        return _userJobService.getAll();
    }
}