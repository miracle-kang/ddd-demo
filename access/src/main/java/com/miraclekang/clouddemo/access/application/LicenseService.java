package com.miraclekang.clouddemo.access.application;

import com.miraclekang.clouddemo.access.domain.model.identity.TenantId;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LicenseService {

    /**
     * Check tenant has license and not expired.
     *
     * @param tenantId tenant id
     * @return
     */
    public Boolean isTenantLicense(String tenantId) {
        System.out.println("Receive request, " + tenantId);
        return true;
    }

    /**
     * Enable tenant license
     *
     * @param tenantId    The id of tenant
     * @param expiredTime License expired time
     */
    public void enableTenantLicense(String tenantId, LocalDateTime expiredTime) {
        System.out.println("Receive enable tenant license request, " +
                "tenantId: " + tenantId + ", expiredTime: " + expiredTime);
    }

    /**
     * Disable tenant license
     *
     * @param tenantId The id of tenant
     */
    public void disableTenantLicense(String tenantId) {
        System.out.println("Receive disable tenant license request, " +
                "tenantId: " + tenantId);
    }
}
