package com.miraclekang.clouddemo.identity.domain.model.identity;

import com.miraclekang.clouddemo.infrastructure.domain.DomainEvent;
import com.miraclekang.clouddemo.infrastructure.domain.model.Enablement;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * User registered domain event
 *
 * @author kangliqi
 * @date 2020/5/18
 */
@Getter
@AllArgsConstructor
public class UserRegistered extends DomainEvent {

    private TenantId tenantId;
    private UserId userId;
    private String username;
    private Enablement enablement;
    private FullName name;
    private EmailAddress email;
}
