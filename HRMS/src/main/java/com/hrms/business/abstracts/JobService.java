package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Job;

import java.util.List;

public interface JobService {
    Result add(Job job);
    DataResult<List<Job>> getAll();
}
