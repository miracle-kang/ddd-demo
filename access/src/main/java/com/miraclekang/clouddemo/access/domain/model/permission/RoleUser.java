package com.miraclekang.clouddemo.access.domain.model.permission;

import com.miraclekang.clouddemo.access.domain.model.identity.TenantId;
import com.miraclekang.clouddemo.access.domain.model.identity.UserId;
import com.miraclekang.clouddemo.infrastructure.domain.ValueObject;
import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class RoleUser extends ValueObject {
    private TenantId tenantId;
    private UserId userId;

    public RoleUser(TenantId tenantId, UserId userId) {
        this.tenantId = tenantId;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        RoleUser roleUser = (RoleUser) o;

        return new EqualsBuilder()
                .append(tenantId, roleUser.tenantId)
                .append(userId, roleUser.userId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(tenantId)
                .append(userId)
                .toHashCode();
    }
}
