package com.hrms.business.concretes;

import com.hrms.business.abstracts.FirmService;
import com.hrms.dataAccess.abstracts.FirmDao;
import com.hrms.entities.concretes.Firm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirmManager implements FirmService {

    @Autowired
    private FirmDao _firmDao;

    @Override
    public List<Firm> getAll() {
        return _firmDao.findAll();
    }
}
