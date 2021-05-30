package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.FirmJob;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FirmJobDao extends JpaRepository<FirmJob, Integer> {
    List<FirmJob> findByIsActiveTrue();
    List<FirmJob> findByIsActiveTrueOrderByEndDate();
    List<FirmJob> findByFirm_FirmId(int firmId);
}
