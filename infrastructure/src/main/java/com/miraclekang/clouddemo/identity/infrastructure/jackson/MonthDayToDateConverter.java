package com.miraclekang.clouddemo.identity.infrastructure.jackson;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.MonthDay;

/**
 * Converts {@link MonthDay} to {@link Date} and back again.
 * <p>
 * Note: Year 2000 is used as default year.
 * </p>
 */
@Converter(autoApply = true)
public class MonthDayToDateConverter implements AttributeConverter<MonthDay, Date> {
    private static final int Y2K = 1970;

    @Override
    public Date convertToDatabaseColumn(MonthDay attribute) {
        return attribute == null ? null : Date.valueOf(attribute.atYear(Y2K));
    }

    @Override
    public MonthDay convertToEntityAttribute(Date dbData) {
        return dbData == null ? null : MonthDay.from(dbData.toLocalDate());
    }
}