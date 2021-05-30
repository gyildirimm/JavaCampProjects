package com.hrms.business.concretes;

import com.hrms.business.abstracts.FirmService;
import com.hrms.business.abstracts.UserService;
import com.hrms.core.utilities.business.BusinessRules;
import com.hrms.core.utilities.results.*;
import com.hrms.dataAccess.abstracts.FirmDao;
import com.hrms.entities.concretes.Firm;
import com.hrms.entities.concretes.User;
import com.hrms.entities.concretes.UserJob;
import com.hrms.entities.dtos.RegisterFirmModel;
import com.hrms.entities.dtos.RegisterUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FirmManager implements FirmService {

    private FirmDao _firmDao;
    private UserService _userService;

    @Autowired
    public FirmManager(FirmDao _firmDao, UserService _userService) {
        this._firmDao = _firmDao;
        this._userService = _userService;
    }

    @Override
    public DataResult<List<Firm>> getAll() {
        return new SuccessDataResult<List<Firm>>(_firmDao.findAll(), "Ürün lisesi");
    }

    @Override
    public Result registerFirm(RegisterFirmModel firm) {
        Result validResult = BusinessRules.Run(
                checkUniqueEmail(firm.getEmail()),
                checkPasswordEquals(firm.getPassword(), firm.getPasswordRepeat())
        );
        if (validResult != null) {
            return validResult;
        }

        DataResult<User> recordedUser = registerUserForFirm(firm);
        if(!recordedUser.isSuccess()) {
            return new ErrorResult(recordedUser.getMessage());
        }

        Firm newFirm = new Firm(
                0,
                recordedUser.getData().getId(),
                firm.getFirmName(),
                firm.getCreateDate(),
                firm.getEmail(),
                firm.getPhone(),
                false,
                false
        );
        _firmDao.save(newFirm);
        if (newFirm.getFirmId() > 0) {
            return new SuccessResult("Firma oluşturuldu");
        }else {
            return new ErrorResult("Firma oluşturulamadı");
        }
    }

    @Override
    public Firm getFirmById(int id) {
        return this._firmDao.getOne(id);
    }

    private Result checkUniqueEmail(String email) {
        if(_firmDao.existsByEmail(email)) {
            return new ErrorResult("Bu mail adresi zaten mevcut");
        }else {
            return new SuccessResult("mail adresi kayıt için uygun");
        }
    }

    private Result checkPasswordEquals(String password, String passwordRepeat) {
        if(!password.equals(passwordRepeat)) {
            return new ErrorResult("Şifre ve Şifre tekrarı aynı değil");
        }else {
            return new SuccessResult();
        }
    }

    private RegisterUserModel firmToUserModel(RegisterFirmModel firm) {
        return new RegisterUserModel(
                firm.getFirmName(),
                firm.getFirmName(),
                firm.getCreateDate(),
                firm.getEmail(),
                firm.getTc(),
                firm.getPassword(),
                firm.getPasswordRepeat(),
                new ArrayList<Integer>()
        );
    }

    private DataResult<User> registerUserForFirm(RegisterFirmModel firm) {
        RegisterUserModel userModel = firmToUserModel(firm);
        Result userRecord = _userService.registerUser(userModel);

        if (!userRecord.isSuccess()) {
            return new ErrorDataResult<User>(userRecord.getMessage());
        }
        User user = _userService.getUserByEmail(firm.getEmail());

        return new SuccessDataResult<User>(user, "");
    }

}
