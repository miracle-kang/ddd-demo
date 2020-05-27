package com.miraclekang.clouddemo.identity.application.command;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChangeTenantInfoCommand {

    @ApiModelProperty("The new tenant name")
    private String name;
    @ApiModelProperty("The new tenant description")
    private String description;
}
