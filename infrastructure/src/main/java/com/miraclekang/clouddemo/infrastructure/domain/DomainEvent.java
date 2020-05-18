package com.miraclekang.clouddemo.infrastructure.domain;

import com.miraclekang.clouddemo.infrastructure.utils.IdentifyUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter(AccessLevel.PRIVATE)
public abstract class DomainEvent implements Serializable {

    private String eventId;
    private Long timestamp;

    protected DomainEvent() {
        this.eventId = IdentifyUtils.nextSnowflakeId();
        this.timestamp = System.currentTimeMillis();
    }
}
