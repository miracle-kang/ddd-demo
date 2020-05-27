package com.miraclekang.clouddemo.identity.port.adapter.service.access;

import com.google.protobuf.Timestamp;
import com.miraclekang.clouddemo.identity.domain.model.access.TenantLicenseService;
import com.miraclekang.clouddemo.identity.domain.model.identity.TenantId;
import com.miraclekang.clouddemo.infrastructure.grpc.IdentityRequest;
import com.miraclekang.clouddemo.infrastructure.grpc.access.EnableTenantLicenseRequest;
import com.miraclekang.clouddemo.infrastructure.grpc.access.TenantLicenseServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class TenantLicenseGRpcClient implements TenantLicenseService {

    @GrpcClient("access-service")
    private TenantLicenseServiceGrpc.TenantLicenseServiceBlockingStub tenantLicenseServiceStub;

    @Override
    public boolean isTenantLicense(TenantId tenantId) {
        return tenantLicenseServiceStub.isTenantLicense(IdentityRequest.newBuilder()
                .setId(tenantId.getId()).build())
                .getValue();
    }

    @Override
    public void enableTenantLicense(TenantId tenantId, LocalDateTime expiredTime) {
        Instant instant = expiredTime.atZone(ZoneId.systemDefault()).toInstant();
        tenantLicenseServiceStub.enableTenantLicense(EnableTenantLicenseRequest.newBuilder()
                .setTenantId(tenantId.getId())
                .setExpiredTime(Timestamp.newBuilder()
                        .setSeconds(instant.getEpochSecond())
                        .setNanos(instant.getNano()).build())
                .build());
    }

    @Override
    public void disableTenantLicense(TenantId tenantId) {
        tenantLicenseServiceStub.disableTenantLicense(IdentityRequest.newBuilder()
                .setId(tenantId.getId())
                .build());
    }
}
