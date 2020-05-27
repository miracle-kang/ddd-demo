package com.miraclekang.clouddemo.identity.application;

import com.miraclekang.clouddemo.identity.application.command.ActivateTenantCommand;
import com.miraclekang.clouddemo.identity.application.command.ChangeTenantInfoCommand;
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

    /**
     * Change tenant info
     *
     * @param tenantId The id of tenant
     * @param command  change tenant info command
     * @return a TenantDto after changed
     */
    TenantDto changeTenantInfo(String tenantId, ChangeTenantInfoCommand command);

    /**
     * Get a tenant
     *
     * @param tenantId The id of tenant
     * @return a TenantDto
     */
    TenantDto tenant(String tenantId);

    /**
     * Activate tenant
     *
     * @param tenantId The id of tenant
     * @param command  Activate tenant command
     */
    void activateTenant(String tenantId, ActivateTenantCommand command);

    /**
     * Deactivate tenant
     *
     * @param tenantId The id of tenant
     */
    void deactivateTenant(String tenantId);
}
