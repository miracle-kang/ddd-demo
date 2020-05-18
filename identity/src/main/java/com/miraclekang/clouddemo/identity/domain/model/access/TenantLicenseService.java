package com.miraclekang.clouddemo.identity.domain.model.access;

import com.miraclekang.clouddemo.identity.domain.model.identity.TenantId;

public interface TenantLicenseService {

    /**
     * is tenant license active
     *
     * @param tenantId tenant id
     * @return true active, false deactive
     */
    boolean isTenantLicense(TenantId tenantId);
}
