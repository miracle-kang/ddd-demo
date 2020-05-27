package com.miraclekang.clouddemo.identity.application.service;

import com.miraclekang.clouddemo.identity.application.TenantManagementService;
import com.miraclekang.clouddemo.identity.application.UserPersionalService;
import com.miraclekang.clouddemo.identity.application.UserRegisterService;
import com.miraclekang.clouddemo.identity.application.command.ProvisionTenantCommand;
import com.miraclekang.clouddemo.identity.application.dto.TenantDto;
import com.miraclekang.clouddemo.identity.domain.model.identity.*;
import com.miraclekang.clouddemo.identity.domain.repository.TenantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IdentityApplicationService
        implements UserRegisterService, UserPersionalService, TenantManagementService {

    private final TenantRepository tenantRepository;
    private final TenantProvisioningService tenantProvisioningService;

    public IdentityApplicationService(TenantRepository tenantRepository,
                                      TenantProvisioningService tenantProvisioningService) {
        this.tenantRepository = tenantRepository;
        this.tenantProvisioningService = tenantProvisioningService;
    }

    @Override
    @Transactional
    public TenantDto provisionTenant(ProvisionTenantCommand command) {
        Tenant tenant = tenantProvisioningService.provisionTenant(
                command.getName(),
                command.getDescription(),
                new FullName(
                        command.getAdministratorFirstName(),
                        command.getAdministratorLastName()
                ),
                new EmailAddress(
                        command.getAdministratorEmailAddress()
                ),
                new Telephone(
                        command.getAdministratorTelephoneNumber()
                )
        );

        return TenantDto.from(tenant);
    }
}
