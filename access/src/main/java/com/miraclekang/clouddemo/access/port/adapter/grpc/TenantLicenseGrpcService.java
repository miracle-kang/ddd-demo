package com.miraclekang.clouddemo.access.port.adapter.grpc;

import com.google.protobuf.Value;
import com.miraclekang.clouddemo.access.application.LicenseService;
import com.miraclekang.clouddemo.access.domain.model.identity.TenantId;
import com.miraclekang.clouddemo.infrastructure.grpc.IdentityRequest;
import com.miraclekang.clouddemo.infrastructure.grpc.access.TenantLicenseServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class TenantLicenseGrpcService extends TenantLicenseServiceGrpc.TenantLicenseServiceImplBase {

    private final LicenseService licenseService;

    public TenantLicenseGrpcService(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @Override
    public void isTenantLicense(IdentityRequest request, StreamObserver<Value> responseObserver) {
        Boolean result = licenseService.isTenantLicense(new TenantId(request.getId()));
        responseObserver.onNext(Value.newBuilder().setBoolValue(result).build());
        responseObserver.onCompleted();
    }
}
