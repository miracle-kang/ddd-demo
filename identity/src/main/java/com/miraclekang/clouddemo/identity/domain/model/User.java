package com.miraclekang.clouddemo.identity.domain.model;

import com.miraclekang.clouddemo.infrastructure.domain.EntityBase;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.Validate;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User extends EntityBase {

    private UserId userId;
    private String username;
    private String password;

    public User(UserId userId, String username, String password) {
        Validate.notNull(userId, "User ID must be provided.");
        Validate.notBlank(username, "Username must be provided.");
        Validate.notBlank(password, "Password must be provided.");

        this.userId = userId;
        this.username = username;
        this.password = password;
    }
}
