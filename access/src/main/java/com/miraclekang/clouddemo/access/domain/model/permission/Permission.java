package com.miraclekang.clouddemo.access.domain.model.permission;

import com.miraclekang.clouddemo.infrastructure.domain.EntityBase;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.Validate;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Permission extends EntityBase {

    private PermissionId permissionId;
    private String name;
    private String code;
    private String description;

    public Permission(PermissionId permissionId, String name, String code, String description) {
        Validate.notNull(permissionId, "Permission Id must be provided.");
        Validate.notBlank(name, "Permission name must be provided.");
        Validate.notBlank(code, "Permission code must be provided.");

        this.permissionId = permissionId;
        this.name = name;
        this.code = code;
        this.description = description;
    }
}
