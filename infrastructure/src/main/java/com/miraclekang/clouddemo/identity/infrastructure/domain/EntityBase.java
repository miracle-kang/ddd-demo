package com.miraclekang.clouddemo.identity.infrastructure.domain;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class EntityBase extends IdentifiedDomainObject implements Serializable {

}
