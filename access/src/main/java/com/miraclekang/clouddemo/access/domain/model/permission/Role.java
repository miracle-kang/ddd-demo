package com.miraclekang.clouddemo.access.domain.model.permission;

import com.miraclekang.clouddemo.infrastructure.domain.EntityBase;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.Validate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Role extends EntityBase {

    private RoleId roleId;
    private String name;
    private String description;

    @CollectionTable(name = "roleUser", joinColumns = @JoinColumn(name = "roleId"))
    @ElementCollection
    private Set<RoleUser> roleUsers = new LinkedHashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId")
    private Set<Permission> permissions = new LinkedHashSet<>();

    public Role(RoleId roleId, String name, String description, List<Permission> permissions) {
        Validate.notNull(roleId, "Role id must be provided.");
        Validate.notBlank(name, "Role name must be provided.");

        this.roleId = roleId;
        this.name = name;
        this.description = description;
        this.addPermissions(permissions);
    }

    private void addPermissions(List<Permission> permissions) {
        if (permissions != null && !permissions.isEmpty()) {
            this.permissions.addAll(permissions);
        }
    }
}
