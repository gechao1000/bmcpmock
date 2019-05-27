package com.budata.mock.annotation;

import java.lang.annotation.*;

/**
 * Jwt interface
 *
 * @author gexc
 * @date 2019/05/27
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Jwt {

    String value() default "token";
}
