package com.miraclekang.clouddemo.access.domain.model.permission;

import com.miraclekang.clouddemo.infrastructure.domain.EntityBase;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Role extends EntityBase {
}
