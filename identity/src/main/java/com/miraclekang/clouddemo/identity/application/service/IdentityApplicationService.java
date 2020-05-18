package com.miraclekang.clouddemo.identity.application.service;

import com.miraclekang.clouddemo.identity.application.TenantManagementService;
import com.miraclekang.clouddemo.identity.application.UserPersionalService;
import com.miraclekang.clouddemo.identity.application.UserRegisterService;
import org.springframework.stereotype.Service;

@Service
public class IdentityApplicationService
        implements UserRegisterService, UserPersionalService, TenantManagementService {


}
