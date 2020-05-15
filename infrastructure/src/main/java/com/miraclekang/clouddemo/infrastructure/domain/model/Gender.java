package com.miraclekang.clouddemo.infrastructure.domain.model;

public enum Gender {

    MALE("男"),

    FEMALE("女"),

    UNKNOWN("未知");

    private String description;

    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Gender getByDescription(String description) {
        for (Gender value : Gender.values()) {
            if (value.description.equals(description)) {
                return value;
            }
        }
        return null;
    }
}
