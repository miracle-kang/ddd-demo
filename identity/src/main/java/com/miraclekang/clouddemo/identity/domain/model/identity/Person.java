package com.miraclekang.clouddemo.identity.domain.model.identity;

import com.miraclekang.clouddemo.infrastructure.domain.EntityBase;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.Validate;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Person extends EntityBase {

    private TenantId tenantId;
    @OneToOne(mappedBy = "userId")
    private User user;
    private FullName name;
    private ContactInformation contact;

    public Person(TenantId tenantId, User user, FullName name, ContactInformation contact) {
        Validate.notNull(tenantId, "The tenantId is required.");
        Validate.notNull(user, "The user is required.");

        this.tenantId = tenantId;
        this.user = user;
        this.name = name;
        this.contact = contact;
    }

    public void changeName(FullName name) {
        Validate.notNull(name, "The name is required.");
        this.name = name;
    }

    public void changeContact(ContactInformation contact) {
        Validate.notNull(contact, "The contact is required.");
        this.contact = contact;
    }
}