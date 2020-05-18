package com.miraclekang.clouddemo.identity.domain.model.identity;

import com.miraclekang.clouddemo.infrastructure.domain.ValueObject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailAddress extends ValueObject {

    private String address;

    public EmailAddress(String address) {
        this.validateSetEmail(address);
    }

    private void validateSetEmail(String anAddress) {
        Validate.notBlank(anAddress, "The email address is required.");
        Validate.isTrue(anAddress.length() > 1 && anAddress.length() < 100,
                "Email address must be 100 character or less.");
        Validate.matchesPattern(anAddress, "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*",
                "Email address format is invalid.");

        this.address = anAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        EmailAddress that = (EmailAddress) o;

        return new EqualsBuilder()
                .append(address, that.address)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(address)
                .toHashCode();
    }
}
