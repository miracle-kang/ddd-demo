package com.miraclekang.clouddemo.identity.application.service;

import com.miraclekang.clouddemo.identity.application.TenantAdministratorService;
import com.miraclekang.clouddemo.identity.application.TenantManagementService;
import com.miraclekang.clouddemo.identity.application.command.ActivateTenantCommand;
import com.miraclekang.clouddemo.identity.application.command.ChangeTenantInfoCommand;
import com.miraclekang.clouddemo.identity.application.command.ProvisionTenantCommand;
import com.miraclekang.clouddemo.identity.application.dto.TenantDto;
import com.miraclekang.clouddemo.identity.domain.model.identity.*;
import com.miraclekang.clouddemo.identity.domain.model.identity.TenantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TenantServiceImpl implements TenantManagementService, TenantAdministratorService {

    private final TenantRepository tenantRepository;
    private final TenantActivateService tenantActivateService;
    private final TenantProvisioningService tenantProvisioningService;

    public TenantServiceImpl(TenantRepository tenantRepository,
                             TenantActivateService tenantActivateService,
                             TenantProvisioningService tenantProvisioningService) {
        this.tenantRepository = tenantRepository;
        this.tenantActivateService = tenantActivateService;
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

    @Override
    @Transactional
    public TenantDto changeTenantInfo(String tenantId, ChangeTenantInfoCommand command) {
        Tenant tenant = existingTenant(tenantId);

        tenant.changeInfo(command.getName(), command.getDescription());
        return TenantDto.from(tenant);
    }

    @Override
    @Transactional(readOnly = true)
    public TenantDto tenant(String tenantId) {
        Tenant tenant = existingTenant(tenantId);

        return TenantDto.from(tenant);
    }

    @Override
    @Transactional
    public void activateTenant(String tenantId, ActivateTenantCommand command) {
        Tenant tenant = existingTenant(tenantId);

        tenantActivateService.activateTenant(tenant,
                command.getExpiredTime());
    }

    @Override
    @Transactional
    public void deactivateTenant(String tenantId) {
        Tenant tenant = existingTenant(tenantId);

        tenantActivateService.deactivateTenant(tenant);
    }

    protected Tenant existingTenant(String aTenantId) {
        Tenant tenant = tenantRepository.findByTenantId(new TenantId(aTenantId));

        if (tenant == null) {
            throw new IllegalArgumentException(
                    "Tenant does not exist for: " + aTenantId);
        }

        return tenant;
    }
}
