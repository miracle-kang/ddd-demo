package com.miraclekang.clouddemo.identity.infrastructure.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@Getter
@ToString
@Setter(value = AccessLevel.PRIVATE)
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractId implements Serializable {

    @Column(length = 64)
    private String id;

    protected AbstractId(String anId) {
        this.id = anId;
    }
}
