package com.hrms.business.concretes;

import com.hrms.business.abstracts.UserJobService;
import com.hrms.core.utilities.results.*;
import com.hrms.dataAccess.abstracts.UserJobDao;
import com.hrms.entities.concretes.UserJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserJobManager implements UserJobService {

    @Autowired
    private UserJobDao _userJobDao;

    @Override
    public DataResult<List<UserJob>> getAll() {
        return new SuccessDataResult<List<UserJob>>(_userJobDao.findAll(), "Ürün lisesi");
    }

    @Override
    public Result addJob(UserJob userJob) {
        _userJobDao.save(userJob);

        if (userJob.getId() > 0) {
         return new SuccessResult("Kayıt başarılı");
        }else {
            return new ErrorResult("Kayıt başarısız");
        }
    }
}
