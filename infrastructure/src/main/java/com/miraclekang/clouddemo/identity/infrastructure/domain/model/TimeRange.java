package com.miraclekang.clouddemo.identity.infrastructure.domain.model;

import com.querydsl.core.annotations.QueryProjection;
import com.miraclekang.clouddemo.identity.infrastructure.domain.ValueObject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeRange extends ValueObject implements Comparable<TimeRange> {

    private LocalTime start;
    private LocalTime end;

    @QueryProjection
    public TimeRange(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public static TimeRange of(LocalTime start, LocalTime end) {
        return new TimeRange(start, end);
    }

    public static TimeRange of(LocalDateTime start, LocalDateTime end) {
        return new TimeRange(
                start == null ? null : start.toLocalTime(),
                end == null ? null : end.toLocalTime()
        );
    }

    /**
     * Obtains an instance of {@code TimeRange} from a text string such as {@code 10:15}.
     * <p>
     * The string must represent a valid time and is parsed using
     * {@link java.time.format.DateTimeFormatter#ISO_LOCAL_TIME}.
     *
     * @param start the text to of such as "10:15:30", not null
     * @param end   the text to of such as "10:15:30", not null
     * @return the parsed local time range, not null
     * @throws DateTimeParseException if the text cannot be parsed
     */
    public static TimeRange parse(String start, String end) {
        return new TimeRange(LocalTime.parse(start), LocalTime.parse(end));
    }

    public static TimeRange none() {
        return new TimeRange(LocalTime.MIDNIGHT, LocalTime.MIDNIGHT);
    }

    public boolean isTimeInRange(LocalTime time) {

        if (time == null) {
            return false;
        }

        return time.isAfter(this.start) && time.isBefore(this.end);
    }

    public DateTimeRange atDate(LocalDate date) {
        Validate.notNull(date, "日期不能为空");
        return new DateTimeRange(
                date.atTime(this.start),
                date.atTime(this.end)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        TimeRange timeRange = (TimeRange) o;

        return new EqualsBuilder()
                .append(start, timeRange.start)
                .append(end, timeRange.end)
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
    public int compareTo(TimeRange o) {
        return this.start.compareTo(o.start);
    }
}
