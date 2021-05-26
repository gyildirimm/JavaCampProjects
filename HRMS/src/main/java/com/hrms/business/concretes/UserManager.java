package com.hrms.business.concretes;

import com.hrms.business.abstracts.UserJobService;
import com.hrms.business.abstracts.UserService;
import com.hrms.core.utilities.business.BusinessRules;
import com.hrms.core.utilities.results.ErrorResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.UserDao;
import com.hrms.entities.concretes.User;
import com.hrms.entities.concretes.UserJob;
import com.hrms.entities.dtos.RegisterUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserManager implements UserService {

    @Autowired
    private UserDao _userDao;

    @Autowired
    private UserJobService _userJobService;

    @Override
    public Result registerUser(RegisterUserModel user) {
        Result validResult = BusinessRules.Run
                (
                    checkPasswordEquals(user.getPassword(), user.getPasswordRepeat()),
                    checkUniqueEmail(user.getEmail()),
                    checkUniqueTc(user.getTc())
                );
        if (validResult != null) {
            return validResult;
        }
        User newUser = new User(
                null,
                user.getFirstName(),
                user.getSecondName(),
                user.getBirthDate(),
                user.getEmail(),
                user.getTc(),
                user.getPassword(),
                true,
                false
                );
        _userDao.save(newUser);
        if (newUser.getId() != null) {
            if (user.getUserJobId() == null) {
                user.setUserJobId(new ArrayList<Integer>());
            }
            for (int jobId : user.getUserJobId()) {
                _userJobService.addJob(new UserJob(0, newUser.getId(), jobId));
            }

            return new SuccessResult("Kullanıcı oluşturuldu");
        }else {
            return new ErrorResult("Kullanıcı oluşturulamadı");
        }
    }

    @Override
    public User getUserByEmail(String email) {
        return _userDao.findByEmail(email);
    }

    private Result checkUniqueEmail(String email) {
        if(_userDao.existsByEmail(email)) {
            return new ErrorResult("Bu mail adresi zaten mevcut");
        }else {
            return new SuccessResult("mail adresi kayıt için uygun");
        }
    }

    private Result checkUniqueTc(String tc) {
        if(_userDao.existsByTc(tc)) {
            return new ErrorResult("Bu kimlik numarası zaten mevcut");
        }else {
            return new SuccessResult("Kimlik numarası kayıt için uygun");
        }
    }

    private Result checkPasswordEquals(String password, String passwordRepeat) {
        if(!password.equals(passwordRepeat)) {
            return new ErrorResult("Şifre ve Şifre tekrarı aynı değil");
        }else {
            return new SuccessResult();
        }
    }
}
