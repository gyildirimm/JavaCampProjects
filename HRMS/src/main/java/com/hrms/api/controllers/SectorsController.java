package com.hrms.api.controllers;

import com.hrms.business.abstracts.JobService;
import com.hrms.business.abstracts.SectorService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Job;
import com.hrms.entities.concretes.Sector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sectors")
public class SectorsController {

    @Autowired
    private SectorService _sectorService;

    @Autowired
    private JobService _jobService;

   @PostMapping("/addSector")
    public Result add(@RequestBody Sector sector) {
        return (this._sectorService.add(sector));
   }

   @GetMapping("/getAllSectors")
    public DataResult<List<Sector>> getAllSectors(){
        return _sectorService.getAll();
   }

    @PostMapping("/addJob")
    public Result add(@RequestBody Job job) {
        return (this._jobService.add(job));
    }

    @GetMapping("/getAllJobs")
    public DataResult<List<Job>> getAllJobs(){
        return _jobService.getAll();
    }
}
