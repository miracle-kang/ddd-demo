package com.miraclekang.clouddemo.access.domain.model.permission;

import com.miraclekang.clouddemo.infrastructure.domain.AbstractId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PermissionId extends AbstractId {

    public PermissionId(String anId) {
        super(anId);
    }
}
