package com.hrms.business.concretes;

import com.hrms.business.abstracts.SectorService;
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
    public void add(Sector sector) {
        this._sectorDao.save(sector);
    }

    @Override
    public List<Sector> getAll() {
        return _sectorDao.findAll();
    }
}
