package com.miraclekang.clouddemo.infrastructure.domain.model;

import com.miraclekang.clouddemo.infrastructure.domain.AbstractId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegionId extends AbstractId {
    public RegionId(String anId) {
        super(anId);
    }
}
