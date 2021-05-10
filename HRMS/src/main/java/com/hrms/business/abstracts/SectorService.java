package com.hrms.business.abstracts;

import com.hrms.entities.concretes.Sector;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SectorService {
    void add(Sector sector);
    List<Sector> getAll();
}
