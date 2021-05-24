package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.entities.concretes.Firm;

import java.util.List;

public interface FirmService {
    DataResult<List<Firm>> getAll();
}
