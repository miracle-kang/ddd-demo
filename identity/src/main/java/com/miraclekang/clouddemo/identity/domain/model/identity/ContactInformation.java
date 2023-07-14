package com.miraclekang.clouddemo.identity.domain.model.identity;

import com.miraclekang.clouddemo.infrastructure.domain.ValueObject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ContactInformation extends ValueObject {

    private EmailAddress email;
    private Telephone telephone;

    public ContactInformation(EmailAddress email, Telephone telephone) {
        this.email = email;
        this.telephone = telephone;
    }

    public ContactInformation changeEmail(EmailAddress anEmail) {
        return new ContactInformation(
                anEmail,
                this.telephone
        );
    }

    public ContactInformation changeTelephone(Telephone anTelephone) {
        return new ContactInformation(
                this.email,
                anTelephone
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ContactInformation that = (ContactInformation) o;

        return new EqualsBuilder()
                .append(email, that.email)
                .append(telephone, that.telephone)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(email)
                .append(telephone)
                .toHashCode();
    }
}
