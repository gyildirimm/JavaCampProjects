package com.hrms.business.concretes;

import com.hrms.business.abstracts.ProvinceService;
import com.hrms.dataAccess.abstracts.ProvinceDao;
import com.hrms.entities.concretes.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceManager implements ProvinceService {

    @Autowired
    private ProvinceDao _provinceDao;

    @Override
    public Province getProvinceById(int id) {
        return this._provinceDao.getOne(id);
    }
}
