package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.User;
import com.hrms.entities.dtos.RegisterUserModel;

public interface UserService {
    Result registerUser(RegisterUserModel user);
    User getUserByEmail(String email);
}
