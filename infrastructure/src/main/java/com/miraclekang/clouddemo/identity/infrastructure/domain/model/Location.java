package com.miraclekang.clouddemo.identity.infrastructure.domain.model;

import com.miraclekang.clouddemo.identity.infrastructure.domain.ValueObject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * 位置信息
 *
 * @author Miracle Kang
 */
@Getter
@Setter(AccessLevel.PRIVATE)
@Embeddable
@NoArgsConstructor
public class Location extends ValueObject {
    /**
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;

    public Location(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String strLocation() {
        return longitude + "," + latitude;
    }
}
