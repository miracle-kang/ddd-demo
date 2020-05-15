package com.miraclekang.clouddemo.infrastructure.domain.model;

import com.miraclekang.clouddemo.infrastructure.domain.ValueObject;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateTimeRange extends ValueObject implements Comparable<DateTimeRange> {

    private LocalDateTime start;
    private LocalDateTime end;

    @QueryProjection
    public DateTimeRange(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public static DateTimeRange of(LocalDateTime start, LocalDateTime end) {
        return new DateTimeRange(start, end);
    }

    public TimeRange toTimeRange() {
        return TimeRange.of(this.start, this.end);
    }

    public boolean isNowInRange() {
        return isTimeInRange(LocalDateTime.now());
    }

    public boolean isTimeInRange(LocalDateTime time) {
        return start.isBefore(time) && end.isAfter(time);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        DateTimeRange that = (DateTimeRange) o;

        return new EqualsBuilder()
                .append(start, that.start)
                .append(end, that.end)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(start)
                .append(end)
                .toHashCode();
    }

    @Override
    public int compareTo(DateTimeRange o) {
        int value = this.start.compareTo(o.start);
        return value == 0 ? this.end.compareTo(o.end) : value;
    }
}
