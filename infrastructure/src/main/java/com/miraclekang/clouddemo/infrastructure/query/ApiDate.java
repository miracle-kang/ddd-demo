package com.miraclekang.clouddemo.infrastructure.query;

import org.springframework.format.annotation.DateTimeFormat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * API 日期格式化
 *
 * @author Miracle Kang
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
public @interface ApiDate {
}
