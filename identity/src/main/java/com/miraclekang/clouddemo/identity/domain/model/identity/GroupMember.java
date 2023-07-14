package com.miraclekang.clouddemo.identity.domain.model.identity;

import com.miraclekang.clouddemo.infrastructure.domain.AbstractId;
import com.miraclekang.clouddemo.infrastructure.domain.IdentifiedValueObject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupMember extends IdentifiedValueObject {

    private TenantId tenantId;
    private GroupMemberType type;
    private String memberId;

    public GroupMember(TenantId tenantId, GroupMemberType type, AbstractId memberId) {
        Validate.notNull(tenantId, "Tenant ID must be provided.");
        Validate.notNull(type, "Member type must be provided.");
        Validate.notNull(memberId, "Member ID must be provided.");

        this.tenantId = tenantId;
        this.type = type;
        this.memberId = memberId.getId();
    }

    public boolean isGroup() {
        return this.type.isGroup();
    }

    public boolean isUser() {
        return this.type.isUser();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        GroupMember that = (GroupMember) o;

        return new EqualsBuilder()
                .append(tenantId, that.tenantId)
                .append(type, that.type)
                .append(memberId, that.memberId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(tenantId)
                .append(type)
                .append(memberId)
                .toHashCode();
    }
}
