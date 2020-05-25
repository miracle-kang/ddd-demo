package com.miraclekang.clouddemo.identity.domain.model.access;

import com.miraclekang.clouddemo.identity.domain.model.identity.TenantId;
import com.miraclekang.clouddemo.identity.domain.model.identity.UserId;

public interface TenantRoleService {

    /**
     * provision a role
     *
     * @param name        a role name, must be Unique with tenantId
     * @param description a role description
     * @return a roleId
     */
    RoleId provisionRole(TenantId tenantId, String name, String description);

    /**
     * Assign a user to a role.
     *
     * @param userId an userId
     * @param roleId a roleId
     */
    void assignUserToRole(UserId userId, RoleId roleId);

    /**
     * Check user has role.
     *
     * @param userId   an userId
     * @param roleName a role name
     * @return true or false
     */
    Boolean userHasRole(UserId userId, String roleName);
}
