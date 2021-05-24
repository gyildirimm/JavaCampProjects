package com.hrms.api.controllers;

import com.hrms.business.abstracts.SectorService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
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

    private SectorService _sectorService;

    @Autowired
    public SectorsController(SectorService sectorService) {
        this._sectorService = sectorService;
    }

   @PostMapping("addSector")
    public Result add(@RequestBody Sector sector) {
        return (this._sectorService.add(sector));
   }

   @GetMapping("getAll")
    public DataResult<List<Sector>> getAll(){
        return _sectorService.getAll();
   }
}
