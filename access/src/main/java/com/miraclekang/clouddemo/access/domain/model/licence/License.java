package com.miraclekang.clouddemo.access.domain.model.licence;

import com.miraclekang.clouddemo.infrastructure.domain.EntityBase;
import com.miraclekang.clouddemo.infrastructure.domain.model.Enablement;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class License extends EntityBase {

    private LicenseId licenseId;
    private Enablement enablement;
}
