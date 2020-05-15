package com.miraclekang.clouddemo.infrastructure.jackson;

import org.springframework.data.convert.Jsr310Converters;
import org.springframework.lang.Nullable;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.*;

/**
 * 自定义时间转换器
 *
 * @author Miracle Kang
 * @date 2019/3/29
 * @see org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters
 * @see org.springframework.data.convert.Jsr310Converters
 */
public class Java8TimeConverter {

    @Converter(autoApply = true)
    public static class LocalDateConverter implements AttributeConverter<LocalDate, java.sql.Date> {
        @Nullable
        @Override
        public java.sql.Date convertToDatabaseColumn(LocalDate entityValue) {
            return entityValue == null ? null : java.sql.Date.valueOf(entityValue);
        }

        @Nullable
        @Override
        public LocalDate convertToEntityAttribute(java.sql.Date databaseValue) {
            return databaseValue == null ? null : databaseValue.toLocalDate();
        }
    }

    @Converter(autoApply = true)
    public static class LocalTimeConverter implements AttributeConverter<LocalTime, java.sql.Time> {
        @Nullable
        @Override
        public java.sql.Time convertToDatabaseColumn(LocalTime attribute) {
            return attribute == null ? null : java.sql.Time.valueOf(attribute);
        }

        @Nullable
        @Override
        public LocalTime convertToEntityAttribute(java.sql.Time dbData) {
            return dbData == null ? null : dbData.toLocalTime();
        }
    }

    @Converter(autoApply = true)
    public static class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, java.util.Date> {

        @Nullable
        @Override
        public java.util.Date convertToDatabaseColumn(LocalDateTime date) {
            return date == null ? null : Jsr310Converters.LocalDateTimeToDateConverter.INSTANCE.convert(date);
        }

        @Nullable
        @Override
        public LocalDateTime convertToEntityAttribute(java.util.Date date) {
            return date == null ? null : Jsr310Converters.DateToLocalDateTimeConverter.INSTANCE.convert(date);
        }
    }

    @Converter(autoApply = true)
    public static class InstantConverter implements AttributeConverter<Instant, java.util.Date> {

        @Nullable
        @Override
        public java.util.Date convertToDatabaseColumn(Instant instant) {
            return instant == null ? null : Jsr310Converters.InstantToDateConverter.INSTANCE.convert(instant);
        }

        @Nullable
        @Override
        public Instant convertToEntityAttribute(java.util.Date date) {
            return date == null ? null : Jsr310Converters.DateToInstantConverter.INSTANCE.convert(date);
        }
    }

    @Converter(autoApply = true)
    public static class ZoneIdConverter implements AttributeConverter<ZoneId, String> {

        @Nullable
        @Override
        public String convertToDatabaseColumn(ZoneId zoneId) {
            return zoneId == null ? null : Jsr310Converters.ZoneIdToStringConverter.INSTANCE.convert(zoneId);
        }

        @Nullable
        @Override
        public ZoneId convertToEntityAttribute(String zoneId) {
            return zoneId == null ? null : Jsr310Converters.StringToZoneIdConverter.INSTANCE.convert(zoneId);
        }
    }
}