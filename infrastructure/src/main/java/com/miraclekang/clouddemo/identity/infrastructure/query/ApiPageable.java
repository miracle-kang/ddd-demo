package com.miraclekang.clouddemo.identity.infrastructure.query;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiImplicitParams({
        @ApiImplicitParam(name = "page", dataTypeClass = Integer.class, defaultValue = "0", paramType = "query", value = "Results page you want to retrieve (0..N)"),
        @ApiImplicitParam(name = "size", dataTypeClass = Integer.class, defaultValue = "20", paramType = "query", value = "Number of records per page."),
        @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(,asc|desc). ")
})
public @interface ApiPageable {
}