package com.miraclekang.clouddemo.identity.domain.model.identity;

import com.miraclekang.clouddemo.infrastructure.domain.DomainEvent;
import lombok.Getter;

@Getter
public class TenantDeactivated extends DomainEvent {

    private TenantId tenantId;
    private String tenantName;

    public TenantDeactivated(TenantId tenantId, String tenantName) {
        this.tenantId = tenantId;
        this.tenantName = tenantName;
    }
}
