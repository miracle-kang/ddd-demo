package com.miraclekang.clouddemo.access.domain.model.identity;

import com.miraclekang.clouddemo.infrastructure.domain.AbstractId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserId extends AbstractId {

    public UserId(String anId) {
        super(anId);
    }
}
