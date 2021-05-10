package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.UserJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJobDao extends JpaRepository<UserJob, Integer> {
}
