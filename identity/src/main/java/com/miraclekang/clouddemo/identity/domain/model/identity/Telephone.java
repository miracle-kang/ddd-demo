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
public class Telephone extends ValueObject {

    private String number;

    public Telephone(String number) {
        this.validateSetNumber(number);
    }

    private void validateSetNumber(String anNumber) {
        Validate.notBlank(anNumber, "Telephone number is required.");
        Validate.isTrue(anNumber.length() > 5 && anNumber.length() < 20,
                "Telephone number may between more then 5 and less then 20 characters.");
        Validate.matchesPattern(anNumber, "((\\(\\d{3}\\))|(\\d{3}-))\\d{3}-\\d{4}",
                "Telephone number or its format is invalid.");

        this.number = anNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Telephone telephone = (Telephone) o;

        return new EqualsBuilder()
                .append(number, telephone.number)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(number)
                .toHashCode();
    }
}
