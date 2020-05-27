package com.miraclekang.clouddemo.identity.domain.model.identity;

import com.miraclekang.clouddemo.infrastructure.domain.DomainEvent;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TenantActivated extends DomainEvent {

    private TenantId tenantId;
    private String tenantName;
    private LocalDateTime expiredTime;

    public TenantActivated(TenantId tenantId, String tenantName, LocalDateTime expiredTime) {
        this.tenantId = tenantId;
        this.tenantName = tenantName;
        this.expiredTime = expiredTime;
    }
}
