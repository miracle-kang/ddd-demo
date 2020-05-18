package com.miraclekang.clouddemo.infrastructure.factory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ObjectMapper对象工厂
 *
 * @author kangliqi
 */
public class ObjectMapperFactory {

    /**
     * 获取ObjectMapper Bean
     *
     * @return instance of ObjectMapper
     */
    public static ObjectMapper objectMapper() {
        return BeanUtil.getBean(ObjectMapper.class);
    }
}
