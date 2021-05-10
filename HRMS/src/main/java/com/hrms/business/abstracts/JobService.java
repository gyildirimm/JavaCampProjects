package com.hrms.business.abstracts;

import com.hrms.entities.concretes.Job;

import java.util.List;

public interface JobService {
    List<Job> getAll();
}
