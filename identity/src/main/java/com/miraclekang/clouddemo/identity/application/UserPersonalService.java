package com.miraclekang.clouddemo.identity.application;

import com.miraclekang.clouddemo.identity.application.dto.UserPersonalInfoDto;
import com.miraclekang.clouddemo.identity.domain.model.identity.UserId;

/**
 * User personal application service
 *
 * @author kangliqi
 * @date 2020/5/18
 */
public interface UserPersonalService {

    /**
     * Get user personal information.
     *
     * @param userId userId
     * @return UserPersonalInfo
     */
    UserPersonalInfoDto userPersonalInfo(UserId userId);
}
