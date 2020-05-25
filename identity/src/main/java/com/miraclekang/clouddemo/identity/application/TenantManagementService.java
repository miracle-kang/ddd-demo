package com.miraclekang.clouddemo.identity.application;

import com.miraclekang.clouddemo.identity.application.command.ProvisionTenantCommand;
import com.miraclekang.clouddemo.identity.application.dto.TenantDto;

/**
 * Specified here
 *
 * @author kangliqi
 * @date 2020/5/18
 */
public interface TenantManagementService {

    /**
     * Provision a tenant
     *
     * @param command provision tenant command
     * @return a tenantDto
     */
    TenantDto provisionTenant(ProvisionTenantCommand command);
}
