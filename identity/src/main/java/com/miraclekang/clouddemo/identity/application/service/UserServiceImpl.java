package com.miraclekang.clouddemo.identity.application.service;

import com.miraclekang.clouddemo.identity.application.UserManagementService;
import com.miraclekang.clouddemo.identity.application.UserPersonalService;
import com.miraclekang.clouddemo.identity.application.UserRegisterService;
import com.miraclekang.clouddemo.identity.application.command.RegisterUserCommand;
import com.miraclekang.clouddemo.identity.application.dto.UserPersonalInfoDto;
import com.miraclekang.clouddemo.identity.domain.model.identity.UserId;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserRegisterService, UserPersonalService, UserManagementService {

    @Override
    public UserPersonalInfoDto userPersonalInfo(UserId userId) {
        return null;
    }

    @Override
    public UserId registerUser(String tenantId, RegisterUserCommand command) {
        return null;
    }

    @Override
    public void sendValidateEmail(UserId userId) {

    }

    @Override
    public void validateEmail(UserId userId, String validateCode) {

    }

    @Override
    public void sendValidateMessage(UserId userId) {

    }

    @Override
    public void validatePhone(UserId userId, String validateCode) {

    }
}
