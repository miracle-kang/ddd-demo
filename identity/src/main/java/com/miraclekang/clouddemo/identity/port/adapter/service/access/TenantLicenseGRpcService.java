package com.miraclekang.clouddemo.identity.port.adapter.service.access;

import com.miraclekang.clouddemo.identity.domain.model.access.TenantLicenseService;
import com.miraclekang.clouddemo.identity.domain.model.identity.TenantId;

/**
 * Tenant License gRPC service implement
 *
 * @author kangliqi
 * @date 2020/5/18
 */
public class TenantLicenseGRpcService implements TenantLicenseService {

    @Override
    public boolean isTenantLicense(TenantId tenantId) {
        return false;
    }
}
