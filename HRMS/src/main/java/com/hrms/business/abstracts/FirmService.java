package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Firm;
import com.hrms.entities.dtos.RegisterFirmModel;

import java.util.List;

public interface FirmService {
    DataResult<List<Firm>> getAll();
    Result registerFirm(RegisterFirmModel firm);
}
