package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceDao extends JpaRepository<Province, Integer> {
}
