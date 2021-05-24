package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorDao extends JpaRepository<Sector, Integer> {
    boolean existsBySectorName(String sectorName);
}
