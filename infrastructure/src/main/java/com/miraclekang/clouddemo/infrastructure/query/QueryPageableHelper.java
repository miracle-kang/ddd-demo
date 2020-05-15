package com.miraclekang.clouddemo.infrastructure.query;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.ComparableExpressionBase;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * QueryDSL查询分页工具
 *
 * @author kangliqi
 * @date 2018/12/13
 */
public class QueryPageableHelper {

    /**
     * 设置分页和排序条件
     * <p>
     * 在执行Projections.construct的时候，无法通过projection确定需要排序的数据表，
     * 所以需要手动指定排序的数据表，如果为null则通过projection获取排序数据表
     *
     * @param query        JPA查询
     * @param pageable     分页和排序信息
     * @param orderEntity  指定需要排序的数据表，影响分页排序信息
     * @param defaultOrder 默认排序，不受指定的排序表影响
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> JPAQuery<T> pageAndSort(JPAQuery<T> query,
                                              Pageable pageable,
                                              EntityPathBase orderEntity,
                                              OrderSpecifier... defaultOrder) {
        if (pageable != null) {
            query.offset(pageable.getOffset());
            query.limit(pageable.getPageSize());
            if (pageable.getSort().isUnsorted()) {
                query.orderBy(defaultOrder);
            } else {
                for (Sort.Order o : pageable.getSort()) {

                    // 构造排序语句
                    PathBuilder builder;
                    String propertyName;
                    if (o.getProperty().indexOf(':') == -1) {
                        builder = (orderEntity != null) ? new PathBuilder(EntityPathBase.class, orderEntity.getMetadata()) :
                                new PathBuilder(EntityPathBase.class, query.getMetadata().getProjection().toString());
                        propertyName = o.getProperty();
                    } else {
                        builder = new PathBuilder(EntityPathBase.class, o.getProperty().substring(0, o.getProperty().indexOf(':')));
                        propertyName = o.getProperty().substring(o.getProperty().indexOf(':') + 1);
                    }

                    query.orderBy(new OrderSpecifier(
                            o.isAscending() ? Order.ASC : Order.DESC,
                            builder.get(propertyName)
                    ));
                }
            }
        } else {
            //不分页
            query.orderBy(defaultOrder);
        }
        return query;
    }

    /**
     * 设置分页和排序条件
     *
     * @param query        JPA查询
     * @param pageable     分页和排序信息
     * @param defaultOrder 默认排序
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> JPAQuery<T> pageAndSort(JPAQuery<T> query,
                                              Pageable pageable,
                                              OrderSpecifier... defaultOrder) {

        return pageAndSort(query, pageable, null, defaultOrder);
    }

    /**
     * 执行分页和排序，直接返回分页后的数据
     * <p>
     * 在执行Projections.construct的时候，无法通过projection确定需要排序的数据表，
     * 所以需要手动指定排序的数据表，如果为null则通过projection获取排序数据表
     *
     * @param query         JPA查询
     * @param pageable      分页和排序信息
     * @param orderEntity   指定需要排序的数据表，影响分页排序信息
     * @param defaultOrders 默认排序，不受指定的排序表影响
     * @param <T>
     * @return
     */
    public static <T> Page<T> executePageAndSort(JPAQuery<T> query,
                                                 Pageable pageable,
                                                 EntityPathBase orderEntity,
                                                 OrderSpecifier... defaultOrders) {
        long total = query.fetchCount();
        return new PageImpl<>(
                pageAndSort(query, pageable, orderEntity, defaultOrders).fetch(),
                pageable,
                total
        );
    }

    /**
     * 执行分页和排序，直接返回分页后的数据
     *
     * @param query         JPA查询
     * @param pageable      分页和排序信息
     * @param defaultOrders 默认排序
     * @param <T>
     * @return
     */
    public static <T> Page<T> executePageAndSort(JPAQuery<T> query,
                                                 Pageable pageable,
                                                 OrderSpecifier... defaultOrders) {
        return executePageAndSort(query, pageable, null, defaultOrders);
    }


    public static JPAQuery<?> applySort(JPAQuery<?> query, ComparableExpressionBase<?> expression, Sort.Direction direction) {

        if (direction == null) {
            return query;
        }

        switch (direction) {
            case ASC:
                query.orderBy(expression.asc());
                break;
            case DESC:
                query.orderBy(expression.desc());
                break;
        }
        return query;
    }
}
