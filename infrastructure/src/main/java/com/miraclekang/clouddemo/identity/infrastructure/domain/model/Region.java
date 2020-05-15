package com.miraclekang.clouddemo.identity.infrastructure.domain.model;

import com.miraclekang.clouddemo.identity.infrastructure.domain.EntityBase;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 地区数据
 *
 * @author Miracle Kang
 */
@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
public class Region extends EntityBase {

    @AttributeOverride(
            name = "id",
            column = @Column(name = "regionId", nullable = false, length = 12, unique = true)
    )
    private RegionId regionId;

    @Column(length = 64)
    private String name;

    @Column(nullable = false)
    private RegionLevel level;

    @AttributeOverride(
            name = "id",
            column = @Column(name = "parentId", length = 12)
    )
    private RegionId parentId;
}
