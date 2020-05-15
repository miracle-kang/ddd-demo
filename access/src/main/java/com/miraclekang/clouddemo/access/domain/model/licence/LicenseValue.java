package com.miraclekang.clouddemo.access.domain.model.licence;

import com.miraclekang.clouddemo.infrastructure.domain.ValueObject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LicenseValue extends ValueObject {

    private LicenseValueType valueType;
    private String value;

    public LicenseValue(LicenseValueType valueType, String value) {
        Validate.notNull(valueType, "License value type must be provided.");
        Validate.notNull(value, "License value must be provided.");

        this.valueType = valueType;
        this.value = value;
    }

    public static LicenseValue enablementValue(Boolean value) {
        Validate.notNull(value, "License value must be provided.");
        return new LicenseValue(LicenseValueType.Enablement, value.toString());
    }

    public static LicenseValue numbericValue(Number value) {
        Validate.notNull(value, "License value must be provided.");
        return new LicenseValue(LicenseValueType.Numberic, value.toString());
    }

    public static LicenseValue dateValue(LocalDateTime value) {
        Validate.notNull(value, "License value must be provided.");
        return new LicenseValue(LicenseValueType.Date, value.format(DateTimeFormatter.ISO_DATE_TIME));
    }
}
