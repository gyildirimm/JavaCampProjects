package com.hrms.business.concretes;

import com.hrms.business.abstracts.JobService;
import com.hrms.dataAccess.abstracts.JobDao;
import com.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobManager implements JobService {

    @Autowired
    private JobDao _jobDao;

    @Override
    public List<Job> getAll() {
        return _jobDao.findAll();
    }
}
