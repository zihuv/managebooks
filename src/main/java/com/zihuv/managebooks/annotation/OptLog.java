package com.zihuv.managebooks.annotation;

import java.lang.annotation.*;

/**
 * 操作日志注解
 *
 * @author: zihuv
 * @date: 2023/2/5
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OptLog {
    /**
     * 操作描述
     */
    String value() default "";
}