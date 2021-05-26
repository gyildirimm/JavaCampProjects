package com.hrms.business.concretes;

import com.hrms.business.abstracts.JobService;
import com.hrms.core.utilities.results.*;
import com.hrms.dataAccess.abstracts.JobDao;
import com.hrms.entities.concretes.Job;
import com.hrms.entities.concretes.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobManager implements JobService {

    @Autowired
    private JobDao _jobDao;

    @Override
    public Result add(Job job) {
        if(this._jobDao.existsByJobName(job.getJobName())) {
            return new ErrorResult("Kayıt başarısız. Aynı isme sahip iş bulunmaktadır.");
        }else {
            this._jobDao.save(job);
            return new SuccessResult("Kayıt Başarılı.");
        }
    }

    @Override
    public DataResult<List<Job>> getAll() {
        return new SuccessDataResult<List<Job>>(_jobDao.findAll(), "İş Listesi");
    }
}
