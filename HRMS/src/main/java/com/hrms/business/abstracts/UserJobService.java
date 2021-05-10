package com.hrms.business.abstracts;

import com.hrms.entities.concretes.UserJob;

import java.util.List;

public interface UserJobService {
    List<UserJob> getAll();
}
