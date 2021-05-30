package com.hrms.api.controllers;

import com.hrms.business.abstracts.FirmJobService;
import com.hrms.business.abstracts.FirmService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Firm;
import com.hrms.entities.dtos.AddFirmJobModel;
import com.hrms.entities.dtos.JobDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/firms")
public class FirmsController {

    private FirmService _firmService;
    private FirmJobService _firmJobService;

    @Autowired
    public FirmsController(FirmService _firmService, FirmJobService _firmJobService) {
        this._firmService = _firmService;
        this._firmJobService = _firmJobService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Firm>> getAll(){
        return _firmService.getAll();
    }

    @PostMapping("/addFirmJob")
    public Result addFirmJob(@RequestBody AddFirmJobModel model) {
        return this._firmJobService.addJob(model);
    }

    @GetMapping("/getAllJobs")
    public DataResult<List<JobDetailModel>> getAllJobs() {
        return this._firmJobService.getAllJobs();
    }

    @GetMapping("/getAllJobsOrderBy")
    public DataResult<List<JobDetailModel>> getAllJobsOrderBy() {
        return this._firmJobService.getAllJobsOrderBy();
    }

    @GetMapping("/getAllJobsByFirm")
    public DataResult<List<JobDetailModel>> getAllJobsByFirm(@RequestParam int firmId) {
        return this._firmJobService.getAllJobsByFirm(firmId);
    }

}
