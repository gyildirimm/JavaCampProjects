package com.hrms.api.controllers;

import com.hrms.business.abstracts.FirmService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.entities.concretes.Firm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/firms")
public class FirmsController {

    @Autowired
    private FirmService _firmService;

    @GetMapping("getAll")
    public DataResult<List<Firm>> getAll(){
        return _firmService.getAll();
    }
}
