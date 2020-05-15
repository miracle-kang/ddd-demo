package com.miraclekang.clouddemo.identity.infrastructure.domain.model;

import com.miraclekang.clouddemo.identity.infrastructure.domain.ValueObject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter(AccessLevel.PRIVATE)
@Embeddable
@NoArgsConstructor
public class BirthDay extends ValueObject {

    public BirthDay(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private int year;

    private int month;

    private int day;

}
