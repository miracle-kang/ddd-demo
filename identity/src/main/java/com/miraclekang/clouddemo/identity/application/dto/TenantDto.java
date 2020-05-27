package com.miraclekang.clouddemo.identity.application.dto;

import com.miraclekang.clouddemo.identity.domain.model.identity.Tenant;
import com.miraclekang.clouddemo.identity.domain.model.identity.TenantId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TenantDto {
    private String tenantId;
    private String name;
    private String description;

    public static TenantDto from(Tenant tenant) {
        if (tenant == null) {
            return nullTenant();
        }
        return new TenantDto(
                tenant.getTenantId().getId(),
                tenant.getName(),
                tenant.getDescription()
        );
    }

    public static TenantDto nullTenant() {
        return new TenantDto(
                null, null, null
        );
    }
}
