package com.okhttplib.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 请求方式
 * @author zhousf
 */
@Retention(RetentionPolicy.SOURCE)
public @interface RequestType {

    /**
     * POST
     */
    int POST = 1;

    /**
     * GET
     */
    int GET = 2;

    /**
     * PUT
     */
    int PUT = 3;

    /**
     * DELETE
     */
    int DELETE = 4;
}