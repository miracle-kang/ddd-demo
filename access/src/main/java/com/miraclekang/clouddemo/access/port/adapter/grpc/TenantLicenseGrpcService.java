package com.miraclekang.clouddemo.access.port.adapter.grpc;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import com.miraclekang.clouddemo.access.application.LicenseService;
import com.miraclekang.clouddemo.access.domain.model.identity.TenantId;
import com.miraclekang.clouddemo.infrastructure.grpc.IdentityRequest;
import com.miraclekang.clouddemo.infrastructure.grpc.access.EnableTenantLicenseRequest;
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
    public void isTenantLicense(IdentityRequest request, StreamObserver<BoolValue> responseObserver) {
        Boolean result = licenseService.isTenantLicense(new TenantId(request.getId()));
        responseObserver.onNext(BoolValue.newBuilder().setValue(result).build());
        responseObserver.onCompleted();
    }

    @Override
    public void enableTenantLicense(EnableTenantLicenseRequest request, StreamObserver<Empty> responseObserver) {
        super.enableTenantLicense(request, responseObserver);
    }

    @Override
    public void disableTenantLicense(IdentityRequest request, StreamObserver<Empty> responseObserver) {
        super.disableTenantLicense(request, responseObserver);
    }
}
