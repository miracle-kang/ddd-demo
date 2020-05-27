package com.miraclekang.clouddemo.identity.application.command;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProvisionTenantCommand {

    @ApiModelProperty("The tenant name")
    private String name;
    @ApiModelProperty("The tenant description")
    private String description;

    @ApiModelProperty("The tenant administrator first name")
    private String administratorFirstName;
    @ApiModelProperty("The tenant administrator last name")
    private String administratorLastName;
    @ApiModelProperty("The tenant administrator email address")
    private String administratorEmailAddress;
    @ApiModelProperty("The tenant administrator telephone number")
    private String administratorTelephoneNumber;
}

