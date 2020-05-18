package com.miraclekang.clouddemo.identity.port.adapter.persistence;

import com.miraclekang.clouddemo.identity.domain.repository.UserRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

/**
 * Customer user repository implement
 *
 * @author kangliqi
 * @date 2020/5/18
 */
@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public UserRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }
}
