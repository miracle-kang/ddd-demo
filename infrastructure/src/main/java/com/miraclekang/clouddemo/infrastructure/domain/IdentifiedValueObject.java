package com.miraclekang.clouddemo.infrastructure.domain;

/**
 * 具有数据库唯一标识的值对象超类
 * 只有当为了使用数据库实体保存多个值对象的时候，才继承自此类
 */
public abstract class IdentifiedValueObject extends IdentifiedDomainObject {
}
