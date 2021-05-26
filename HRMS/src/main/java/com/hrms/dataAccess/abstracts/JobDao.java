package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDao extends JpaRepository<Job, Integer> {
    boolean existsByJobName(String jobName);
}
