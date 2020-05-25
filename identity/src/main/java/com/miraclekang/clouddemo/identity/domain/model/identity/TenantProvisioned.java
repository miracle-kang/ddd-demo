package com.miraclekang.clouddemo.identity.domain.model.identity;

import com.miraclekang.clouddemo.infrastructure.domain.DomainEvent;
import lombok.Getter;

@Getter
public class TenantProvisioned extends DomainEvent {

    private TenantId tenantId;

    public TenantProvisioned(TenantId tenantId) {
        this.tenantId = tenantId;
    }
}
