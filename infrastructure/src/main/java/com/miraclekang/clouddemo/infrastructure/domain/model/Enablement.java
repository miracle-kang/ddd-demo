package com.miraclekang.clouddemo.infrastructure.domain.model;

import com.miraclekang.clouddemo.infrastructure.domain.ValueObject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Enablement extends ValueObject {

    private Boolean enable;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Enablement(Boolean enable, LocalDateTime startDate, LocalDateTime endDate) {
        this.setEnable(BooleanUtils.isTrue(enable));

        if (startDate != null || endDate != null) {
            Validate.notNull(startDate, "The start date must be provided.");
            Validate.notNull(endDate, "The end date must be provided.");
            Validate.isTrue(startDate.isBefore(endDate), "Enablement start and/or end date is invalid.");
        }

        this.setStartDate(startDate);
        this.setEndDate(endDate);
    }

    public static Enablement indefinite() {
        return new Enablement(true, null, null);
    }

    public boolean isEnable() {
        return BooleanUtils.isTrue(enable);
    }

    public boolean isEnablementEnable() {
        return this.isEnable() && !isTimeExpired();
    }

    public boolean isTimeExpired() {
        boolean expired = false;

        if (this.startDate != null && this.endDate != null) {
            LocalDateTime now = LocalDateTime.now();
            if (now.isBefore(this.startDate) || now.isAfter(this.endDate)) {
                expired = true;
            }
        }

        return expired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Enablement that = (Enablement) o;

        return new EqualsBuilder()
                .append(enable, that.enable)
                .append(startDate, that.startDate)
                .append(endDate, that.endDate)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(enable)
                .append(startDate)
                .append(endDate)
                .toHashCode();
    }
}
