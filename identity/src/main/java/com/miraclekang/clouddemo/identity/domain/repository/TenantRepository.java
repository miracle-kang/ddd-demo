package com.miraclekang.clouddemo.identity.domain.repository;

import com.miraclekang.clouddemo.identity.domain.model.identity.Tenant;
import com.miraclekang.clouddemo.identity.domain.model.identity.TenantId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

    /**
     * Find a tenant by tenantId
     *
     * @param tenantId The tenantId
     * @return A tenant
     */
    Tenant findByTenantId(TenantId tenantId);
}
