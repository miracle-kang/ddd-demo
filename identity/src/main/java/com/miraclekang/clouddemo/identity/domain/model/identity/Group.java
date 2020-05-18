package com.miraclekang.clouddemo.identity.domain.model.identity;

import com.miraclekang.clouddemo.infrastructure.domain.EntityBase;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Group extends EntityBase {

    private TenantId tenantId;
    private GroupId groupId;
    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "groupId")
    private Set<GroupMember> groupMembers = new LinkedHashSet<>();

    public Group(TenantId tenantId, GroupId groupId, String name, String description) {
        this.tenantId = tenantId;
        this.groupId = groupId;
        this.name = name;
        this.description = description;
    }
}
