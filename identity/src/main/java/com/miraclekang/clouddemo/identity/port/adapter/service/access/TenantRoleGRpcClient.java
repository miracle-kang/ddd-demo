package com.miraclekang.clouddemo.identity.port.adapter.service.access;

import com.miraclekang.clouddemo.identity.domain.model.access.RoleId;
import com.miraclekang.clouddemo.identity.domain.model.access.TenantRoleService;
import com.miraclekang.clouddemo.identity.domain.model.identity.TenantId;
import com.miraclekang.clouddemo.identity.domain.model.identity.UserId;
import com.miraclekang.clouddemo.infrastructure.grpc.IdentityResponse;
import com.miraclekang.clouddemo.infrastructure.grpc.access.AssignUserToRoleRequest;
import com.miraclekang.clouddemo.infrastructure.grpc.access.ProvisionRoleRequest;
import com.miraclekang.clouddemo.infrastructure.grpc.access.TenantRoleServiceGrpc;
import com.miraclekang.clouddemo.infrastructure.grpc.access.UserHasRoleRequest;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class TenantRoleGRpcClient implements TenantRoleService {

    @GrpcClient("access-service")
    private TenantRoleServiceGrpc.TenantRoleServiceBlockingStub tenantRoleServiceBlockingStub;

    @Override
    public RoleId provisionRole(TenantId tenantId, String name, String description) {
        IdentityResponse response = tenantRoleServiceBlockingStub.provisionRole(ProvisionRoleRequest.newBuilder()
                .setTenantId(tenantId.getId())
                .setName(name)
                .setDescription(description)
                .build());

        return new RoleId(response.getId());
    }

    @Override
    public void assignUserToRole(UserId userId, RoleId roleId) {
        tenantRoleServiceBlockingStub.assignUserToRole(AssignUserToRoleRequest.newBuilder()
                .setUserId(userId.getId())
                .setRoleId(roleId.getId())
                .build());
    }

    @Override
    public Boolean userHasRole(UserId userId, String roleName) {
        return tenantRoleServiceBlockingStub.userHasRole(UserHasRoleRequest.newBuilder()
                .setUserId(userId.getId())
                .setRoleName(roleName).build())
                .getValue();
    }
}
