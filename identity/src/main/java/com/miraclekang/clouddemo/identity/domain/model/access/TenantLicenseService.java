package com.miraclekang.clouddemo.identity.domain.model.access;

import com.miraclekang.clouddemo.identity.domain.model.identity.TenantId;

import java.time.LocalDateTime;

public interface TenantLicenseService {

    /**
     * is tenant license active
     *
     * @param tenantId An id of tenant
     * @return true active, false deactive
     */
    boolean isTenantLicense(TenantId tenantId);

    /**
     * Enable tenant license
     *
     * @param tenantId    An id of tenant
     * @param expiredTime Tenant license expired time
     */
    void enableTenantLicense(TenantId tenantId, LocalDateTime expiredTime);

    /**
     * Disable tenant license
     *
     * @param tenantId An id of tenant
     */
    void disableTenantLicense(TenantId tenantId);
}
