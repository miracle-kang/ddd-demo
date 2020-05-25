package com.miraclekang.clouddemo.identity.domain.model.access;

import com.miraclekang.clouddemo.infrastructure.domain.AbstractId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoleId extends AbstractId {

    public RoleId(String anId) {
        super(anId);
    }
}
