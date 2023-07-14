package com.miraclekang.clouddemo.access.domain.model.licence;

import com.miraclekang.clouddemo.infrastructure.domain.IdentifiedValueObject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.Validate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LicenseItem extends IdentifiedValueObject {

    private ModuleId moduleId;
    private LicenseValue value;

    public LicenseItem(ModuleId moduleId, LicenseValue value) {
        Validate.notNull(moduleId, "License module id must be provided.");
        Validate.notNull(value, "License value must be provided.");

        this.moduleId = moduleId;
        this.value = value;
    }
}
