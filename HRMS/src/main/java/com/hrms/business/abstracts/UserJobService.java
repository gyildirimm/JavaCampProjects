package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.UserJob;

import java.util.List;

public interface UserJobService {
    DataResult<List<UserJob>> getAll();
    Result addJob(UserJob userJob);
}
