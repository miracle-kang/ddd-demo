package com.miraclekang.clouddemo.access.domain.model.licence;

import com.miraclekang.clouddemo.infrastructure.domain.EntityBase;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.Validate;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Module extends EntityBase {

    private ModuleId moduleId;
    private String name;
    private String code;

    public Module(ModuleId moduleId, String name, String code) {
        Validate.notNull(moduleId, "Module Id must be provided.");
        Validate.notBlank(name, "Module name must be provided.");
        Validate.notBlank(code, "Module code must be provided.");

        this.moduleId = moduleId;
        this.name = name;
        this.code = code;
    }
}
