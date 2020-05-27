package com.miraclekang.clouddemo.identity.application.command;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ActivateTenantCommand {

    @ApiModelProperty("Tenant expired time")
    private LocalDateTime expiredTime;
}
