package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.dtos.AddFirmJobModel;
import com.hrms.entities.dtos.JobDetailModel;

import java.util.List;

public interface FirmJobService {
    Result addJob(AddFirmJobModel model);
    DataResult<List<JobDetailModel>> getAllJobs();
    DataResult<List<JobDetailModel>> getAllJobsOrderBy();
    DataResult<List<JobDetailModel>> getAllJobsByFirm(int id);
}
