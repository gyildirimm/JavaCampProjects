package com.hrms.api.controllers;

import com.hrms.business.abstracts.JobService;
import com.hrms.business.abstracts.SectorService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Job;
import com.hrms.entities.concretes.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {

    @Autowired
    private JobService _jobService;

    @PostMapping("/addJob")
    public Result add(@RequestBody Job job) {
        return (this._jobService.add(job));
    }

    @GetMapping("/getAll")
    public DataResult<List<Job>> getAll(){
        return _jobService.getAll();
    }
}