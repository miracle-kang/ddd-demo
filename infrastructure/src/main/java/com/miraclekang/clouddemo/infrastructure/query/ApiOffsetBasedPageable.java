package com.miraclekang.clouddemo.infrastructure.query;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiImplicitParams({
        @ApiImplicitParam(name = "offset", dataTypeClass = Integer.class, defaultValue = "0", paramType = "query", value = "zero-based offset."),
        @ApiImplicitParam(name = "limit", dataTypeClass = Integer.class, defaultValue = "20", paramType = "query", value = "the size of the elements to be returned."),
        @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(,asc|desc). ")
})
public @interface ApiOffsetBasedPageable {
}
