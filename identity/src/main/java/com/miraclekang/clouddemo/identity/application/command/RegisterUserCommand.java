package com.miraclekang.clouddemo.identity.application.command;

import com.miraclekang.clouddemo.identity.domain.model.identity.ContactInformation;
import com.miraclekang.clouddemo.identity.domain.model.identity.FullName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserCommand {
    private String username;
    private String password;
    private FullName fullName;
    private ContactInformation contactInformation;
}
