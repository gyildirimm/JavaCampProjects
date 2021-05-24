package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Sector;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SectorService {
    Result add(Sector sector);
    DataResult<List<Sector>> getAll();
}
