package com.miraclekang.clouddemo.identity.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProvisionTenantCommand {
    private String name;
    private String description;

    private String administratorFirstName;
    private String administratorLastName;
    private String administratorEmailAddress;
    private String administratorTelephoneNumber;
}

