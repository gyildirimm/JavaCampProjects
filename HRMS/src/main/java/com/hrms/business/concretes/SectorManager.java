package com.hrms.business.concretes;

import com.hrms.business.abstracts.SectorService;
import com.hrms.core.utilities.results.*;
import com.hrms.dataAccess.abstracts.SectorDao;
import com.hrms.entities.concretes.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorManager implements SectorService {

    @Autowired
    private SectorDao _sectorDao;

    @Override
    public Result add(Sector sector) {
        if(this._sectorDao.existsBySectorName(sector.getSectorName())) {
            return new ErrorResult("Kayıt başarısız. Aynı isme sahip sector bulunmaktadır.");
        }else {
            this._sectorDao.save(sector);
            return new SuccessResult("Kayıt Başarılı.");
        }
    }

    @Override
    public DataResult<List<Sector>> getAll() {
        return new SuccessDataResult<List<Sector>>(_sectorDao.findAll(), "Sektör Listesi");
    }
}
