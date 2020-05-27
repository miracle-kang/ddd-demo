package com.miraclekang.clouddemo.identity.domain.model.identity;

import com.miraclekang.clouddemo.identity.domain.model.access.TenantLicenseService;
import com.miraclekang.clouddemo.infrastructure.domain.DomainEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Specified here
 *
 * @author kangliqi
 * @date 2020/5/27
 */
@Service
public class TenantActivateService {

    private final TenantLicenseService tenantLicenseService;

    public TenantActivateService(TenantLicenseService tenantLicenseService) {
        this.tenantLicenseService = tenantLicenseService;
    }

    public void activateTenant(Tenant tenant, LocalDateTime expiredTime) {
        tenantLicenseService.enableTenantLicense(tenant.getTenantId(), expiredTime);

        DomainEventPublisher.instance()
                .publish(new TenantActivated(tenant.getTenantId(),
                        tenant.getName(),
                        expiredTime));
    }

    public void deactivateTenant(Tenant tenant) {
        tenantLicenseService.disableTenantLicense(tenant.getTenantId());

        DomainEventPublisher.instance()
                .publish(new TenantDeactivated(tenant.getTenantId(),
                        tenant.getName()));
    }
}
