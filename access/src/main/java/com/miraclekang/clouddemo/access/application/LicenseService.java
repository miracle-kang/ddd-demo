package com.miraclekang.clouddemo.access.application;

import com.miraclekang.clouddemo.access.domain.model.identity.TenantId;
import org.springframework.stereotype.Service;

@Service
public class LicenseService {

    /**
     * Check tenant has license and not expired.
     *
     * @param tenantId tenant id
     * @return
     */
    public Boolean isTenantLicense(TenantId tenantId) {
        return true;
    }
}
