package com.fandou.springboot.rabbitmq.support;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PrintThread {
    String value() default "";
}
