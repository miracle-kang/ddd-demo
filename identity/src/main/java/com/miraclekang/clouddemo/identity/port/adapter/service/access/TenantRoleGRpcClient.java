package com.miraclekang.clouddemo.identity.port.adapter.service.access;

import com.miraclekang.clouddemo.identity.domain.model.access.RoleId;
import com.miraclekang.clouddemo.identity.domain.model.access.TenantRoleService;
import com.miraclekang.clouddemo.identity.domain.model.identity.TenantId;
import com.miraclekang.clouddemo.identity.domain.model.identity.UserId;
import org.springframework.stereotype.Service;

@Service
public class TenantRoleGRpcClient implements TenantRoleService {

    @Override
    public RoleId provisionRole(TenantId tenantId, String name, String description) {
        return null;
    }

    @Override
    public void assignUserToRole(UserId userId, RoleId roleId) {

    }

    @Override
    public Boolean userHasRole(UserId userId, String roleName) {
        return null;
    }
}
