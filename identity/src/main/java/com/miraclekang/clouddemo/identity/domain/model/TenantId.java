package com.miraclekang.clouddemo.identity.domain.model;

import com.miraclekang.clouddemo.infrastructure.domain.AbstractId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TenantId extends AbstractId {

    public TenantId(String anId) {
        super(anId);
    }
}
