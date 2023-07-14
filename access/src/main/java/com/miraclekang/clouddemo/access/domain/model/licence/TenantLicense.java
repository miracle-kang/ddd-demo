package com.miraclekang.clouddemo.access.domain.model.licence;

import com.miraclekang.clouddemo.access.domain.model.identity.TenantId;
import com.miraclekang.clouddemo.infrastructure.domain.IdentifiedDomainObject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TenantLicense extends IdentifiedDomainObject {

    private TenantId tenantId;
    private License license;

    public TenantLicense(TenantId tenantId, License license) {
        this.tenantId = tenantId;
        this.license = license;
    }
}
