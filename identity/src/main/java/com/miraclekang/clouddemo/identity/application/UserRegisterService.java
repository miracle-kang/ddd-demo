package com.miraclekang.clouddemo.identity.application;

import com.miraclekang.clouddemo.identity.application.command.RegisterUserCommand;
import com.miraclekang.clouddemo.identity.domain.model.identity.UserId;

/**
 * User register application service
 *
 * @author kangliqi
 * @date 2020/5/18
 */
public interface UserRegisterService {

    /**
     * Register a new user
     *
     * @param tenantId The tenant that user register for
     * @param command  user info command
     * @return registered user id
     */
    UserId registerUser(String tenantId, RegisterUserCommand command);

    /**
     * Send a validate email to user mailbox
     *
     * @param userId userId
     */
    void sendValidateEmail(UserId userId);

    /**
     * Validate user email
     *
     * @param userId       userId
     * @param validateCode validate code
     */
    void validateEmail(UserId userId, String validateCode);

    /**
     * send a validate message to user phone
     *
     * @param userId userId
     */
    void sendValidateMessage(UserId userId);

    /**
     * Validate user phone number
     *
     * @param userId       userId
     * @param validateCode validate code
     */
    void validatePhone(UserId userId, String validateCode);
}
