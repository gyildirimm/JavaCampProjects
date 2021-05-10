package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.Firm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirmDao extends JpaRepository<Firm, Integer> {
}
