package com.miraclekang.clouddemo.identity.domain.model.identity;

import com.miraclekang.clouddemo.infrastructure.domain.EntityBase;
import com.miraclekang.clouddemo.infrastructure.domain.model.Enablement;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.Validate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User extends EntityBase {

    private TenantId tenantId;
    private UserId userId;
    private String username;
    private String password;
    private Enablement enablement;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personId")
    private Person person;

    protected User(TenantId tenantId, UserId userId, String username, String password, Enablement enablement, Person person) {
        Validate.notNull(tenantId, "Tenant ID must be provided.");
        Validate.notNull(userId, "User ID must be provided.");
        Validate.notBlank(username, "Username must be provided.");
        Validate.notBlank(password, "Password must be provided.");
        Validate.notNull(enablement, "The enablement is required.");
        Validate.notNull(person, "Person info must be provided.");

        this.tenantId = tenantId;
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.enablement = enablement;
        this.person = person;

        person.internalSetUser(this);
    }


}
