package com.hrms.api.controllers;

import com.hrms.business.abstracts.FirmService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Firm;
import com.hrms.entities.dtos.RegisterFirmModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/firms")
public class FirmsController {

    @Autowired
    private FirmService _firmService;

    @GetMapping("/getAll")
    public DataResult<List<Firm>> getAll(){
        return _firmService.getAll();
    }

    @PostMapping("/registerFirm")
    public Result registerFirm(@RequestBody RegisterFirmModel firm) {
        return this._firmService.registerFirm(firm);
    }
}
