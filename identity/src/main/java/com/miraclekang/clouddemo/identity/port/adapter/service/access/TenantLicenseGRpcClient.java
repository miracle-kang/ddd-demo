package com.miraclekang.clouddemo.identity.port.adapter.service.access;

import com.miraclekang.clouddemo.identity.domain.model.access.TenantLicenseService;
import com.miraclekang.clouddemo.identity.domain.model.identity.TenantId;
import com.miraclekang.clouddemo.infrastructure.grpc.IdentityRequest;
import com.miraclekang.clouddemo.infrastructure.grpc.access.TenantLicenseServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class TenantLicenseGRpcClient implements TenantLicenseService {

    @GrpcClient("tenant-license-service")
    private TenantLicenseServiceGrpc.TenantLicenseServiceBlockingStub tenantLicenseServiceStub;

    @Override
    public boolean isTenantLicense(TenantId tenantId) {
        return tenantLicenseServiceStub.isTenantLicense(IdentityRequest.newBuilder().setId(tenantId.getId()).build())
                .getBoolValue();
    }
}
