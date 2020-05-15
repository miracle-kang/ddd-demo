package com.miraclekang.clouddemo.identity.infrastructure.domain.model;

import com.miraclekang.clouddemo.identity.infrastructure.domain.AbstractId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegionId extends AbstractId {
    public RegionId(String anId) {
        super(anId);
    }
}
