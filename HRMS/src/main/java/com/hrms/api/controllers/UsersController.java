package com.hrms.api.controllers;

import com.hrms.business.concretes.UserManager;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.dtos.RegisterUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UserManager _userManager;

    @PostMapping("/registerUser")
    public Result registerUser(@RequestBody RegisterUserModel user) {
        return this._userManager.registerUser(user);
    }
}
