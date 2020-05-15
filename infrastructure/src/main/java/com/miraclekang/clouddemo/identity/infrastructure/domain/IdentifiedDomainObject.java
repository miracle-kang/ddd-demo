package com.miraclekang.clouddemo.identity.infrastructure.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 数据库唯一标识委派类
 */
@Getter
@Setter(AccessLevel.PRIVATE)
@MappedSuperclass
public abstract class IdentifiedDomainObject extends AbstractAggregateRoot implements Serializable {

    @Getter(AccessLevel.PUBLIC)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @PreRemove
    protected final void preRemove() {
        if (this instanceof EntityAutoDelete) {
            ((EntityAutoDelete) this).clean();
        }

        this.onRemove();
    }

    /**
     * 实现类在需要的时候覆盖该方法
     */
    protected void onRemove() {
        // ignore
    }

    @PrePersist
    protected final void onCreate() {
        this.setCreatedDate(LocalDateTime.now());
        this.setLastModifiedDate(LocalDateTime.now());
    }

    @PreUpdate
    protected final void onUpdate() {
        this.setLastModifiedDate(LocalDateTime.now());
    }
}
