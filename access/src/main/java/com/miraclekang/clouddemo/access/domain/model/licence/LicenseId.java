package com.miraclekang.clouddemo.access.domain.model.licence;

import com.miraclekang.clouddemo.infrastructure.domain.AbstractId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LicenseId extends AbstractId {

    public LicenseId(String anId) {
        super(anId);
    }
}
