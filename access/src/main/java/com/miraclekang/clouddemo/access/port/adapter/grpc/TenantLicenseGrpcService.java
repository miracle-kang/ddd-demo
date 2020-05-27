package com.miraclekang.clouddemo.access.port.adapter.grpc;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import com.miraclekang.clouddemo.access.application.LicenseService;
import com.miraclekang.clouddemo.infrastructure.grpc.IdentityRequest;
import com.miraclekang.clouddemo.infrastructure.grpc.access.EnableTenantLicenseRequest;
import com.miraclekang.clouddemo.infrastructure.grpc.access.TenantLicenseServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.time.Instant;
import java.time.ZoneId;

@GrpcService
public class TenantLicenseGrpcService extends TenantLicenseServiceGrpc.TenantLicenseServiceImplBase {

    private final LicenseService licenseService;

    public TenantLicenseGrpcService(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @Override
    public void isTenantLicense(IdentityRequest request, StreamObserver<BoolValue> responseObserver) {
        Boolean result = licenseService.isTenantLicense(request.getId());
        responseObserver.onNext(BoolValue.newBuilder().setValue(result).build());
        responseObserver.onCompleted();
    }

    @Override
    public void enableTenantLicense(EnableTenantLicenseRequest request, StreamObserver<Empty> responseObserver) {
        licenseService.enableTenantLicense(request.getTenantId(),
                Instant.ofEpochSecond(request.getExpiredTime().getNanos(), request.getExpiredTime().getNanos())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime());
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void disableTenantLicense(IdentityRequest request, StreamObserver<Empty> responseObserver) {
        licenseService.disableTenantLicense(request.getId());
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }
}
