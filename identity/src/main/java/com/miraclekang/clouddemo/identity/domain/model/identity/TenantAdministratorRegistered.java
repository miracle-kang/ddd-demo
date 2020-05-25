package com.miraclekang.clouddemo.identity.domain.model.identity;

import com.miraclekang.clouddemo.infrastructure.domain.DomainEvent;
import lombok.Getter;

@Getter
public class TenantAdministratorRegistered extends DomainEvent {

    private TenantId tenantId;
    private String tenantName;

    private UserId adminUserId;
    private FullName adminName;
    private EmailAddress emailAddress;
    private String adminUsername;

    public TenantAdministratorRegistered(TenantId tenantId, String tenantName,
                                         UserId adminUserId, String adminUsername,
                                         FullName adminName, EmailAddress emailAddress) {
        this.tenantId = tenantId;
        this.tenantName = tenantName;
        this.adminUserId = adminUserId;
        this.adminUsername = adminUsername;
        this.adminName = adminName;
        this.emailAddress = emailAddress;
    }
}
