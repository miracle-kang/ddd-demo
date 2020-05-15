package com.miraclekang.clouddemo.infrastructure.domain;

import lombok.*;
import org.apache.commons.lang3.Validate;

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
        Validate.notBlank(anId, "ID must not be blank string.");

        this.id = anId;
    }
}
