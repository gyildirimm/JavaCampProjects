package com.hrms.api.controllers;

import com.hrms.business.abstracts.FirmService;
import com.hrms.business.abstracts.UserService;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.dtos.RegisterFirmModel;
import com.hrms.entities.dtos.RegisterUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private UserService _userService;
    private FirmService _firmService;

    @Autowired
    public AuthController(UserService _userService, FirmService _firmService) {
        this._userService = _userService;
        this._firmService = _firmService;
    }

    @PostMapping("/registerUser")
    public Result registerUser(@RequestBody RegisterUserModel user) {
        return this._userService.registerUser(user);
    }

    @PostMapping("/registerFirm")
    public Result registerFirm(@RequestBody RegisterFirmModel firm) {
        return this._firmService.registerFirm(firm);
    }
}
