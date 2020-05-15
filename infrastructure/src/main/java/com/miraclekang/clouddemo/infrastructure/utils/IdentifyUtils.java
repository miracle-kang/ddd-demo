package com.miraclekang.clouddemo.infrastructure.utils;

import java.util.UUID;

/**
 * 唯一标识工具类
 *
 * @author kangliqi
 * @date 2018/12/7
 */
public class IdentifyUtils {

    private static Snowflake snowflake = new Snowflake();

    /**
     * 生成SnowFlake唯一标识
     *
     * @return
     */
    public static String nextSnowflakeId() {
        return String.valueOf(snowflake.nextId());
    }

    /**
     * 生成UUID唯一标识
     *
     * @return
     */
    public static String nextUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
