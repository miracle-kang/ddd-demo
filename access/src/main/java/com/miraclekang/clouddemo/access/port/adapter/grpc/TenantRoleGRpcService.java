package com.miraclekang.clouddemo.access.port.adapter.grpc;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import com.miraclekang.clouddemo.infrastructure.grpc.IdentityResponse;
import com.miraclekang.clouddemo.infrastructure.grpc.access.AssignUserToRoleRequest;
import com.miraclekang.clouddemo.infrastructure.grpc.access.ProvisionRoleRequest;
import com.miraclekang.clouddemo.infrastructure.grpc.access.TenantRoleServiceGrpc;
import com.miraclekang.clouddemo.infrastructure.grpc.access.UserHasRoleRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * Specified here
 *
 * @author kangliqi
 * @date 2020/5/27
 */
@GrpcService
public class TenantRoleGRpcService extends TenantRoleServiceGrpc.TenantRoleServiceImplBase {

    @Override
    public void provisionRole(ProvisionRoleRequest request, StreamObserver<IdentityResponse> responseObserver) {
        super.provisionRole(request, responseObserver);
    }

    @Override
    public void assignUserToRole(AssignUserToRoleRequest request, StreamObserver<Empty> responseObserver) {
        super.assignUserToRole(request, responseObserver);
    }

    @Override
    public void userHasRole(UserHasRoleRequest request, StreamObserver<BoolValue> responseObserver) {
        super.userHasRole(request, responseObserver);
    }
}
